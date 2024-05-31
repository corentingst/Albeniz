
package com.theodo.Albeniz.controller;

import com.theodo.Albeniz.Service.LibraryService;
import com.theodo.Albeniz.dto.Tune;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = LibraryController.class)
public class LibraryControllerTest {

    @MockBean
    private LibraryService libraryService;

    @Autowired
    private MockMvc mockMvc;


    List<Tune> completeLibrary = Arrays.asList(
            new Tune(1, "Thriller", "MJ"),
            new Tune(2, "Bohemian Rhapsody", "Queen"),
            new Tune(3, "Allumer le feu", "Johnny")
    );

    List<Tune> searchedLibrary = Arrays.asList(
            new Tune(1, "Thriller", "MJ"),
            new Tune(3, "Allumer le feu", "Johnny")
    );

    Tune bohemianTune = new Tune(2, "Bohemian Rhapsody", "Queen");

    @Test
    public void testGetLibraryRouteWithoutSearchQueryTerm() throws Exception{
        BDDMockito.given(this.libraryService.getMusic(null)).willReturn(completeLibrary);
        mockMvc.perform(get("/library/music").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[" +
                                "{'id': 1, 'title': 'Thriller', 'author': 'MJ'}," +
                                "{'id': 2, 'title': 'Bohemian Rhapsody', 'author': 'Queen'}," +
                                "{'id': 3, 'title': 'Allumer le feu', 'author': 'Johnny'}" +
                                "]"));
    }

    @Test
    public void testGetLibraryRouteWithSearchQueryTerm() throws Exception{
        BDDMockito.given(this.libraryService.getMusic("ll")).willReturn(searchedLibrary);
        mockMvc.perform(get("/library/music?query=ll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[" +
                                "{'id': 1, 'title': 'Thriller', 'author': 'MJ'}," +
                                "{'id': 3, 'title': 'Allumer le feu', 'author': 'Johnny'}" +
                                "]"));
    }

    @Test
    public void testGetLibraryRouteWithSear() throws Exception{
        BDDMockito.given(this.libraryService.getOne(2)).willReturn(bohemianTune);
        mockMvc.perform(get("/library/music/2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{'id': 2, 'title': 'Bohemian Rhapsody', 'author': 'Queen'}"
                ));
    }
    }
