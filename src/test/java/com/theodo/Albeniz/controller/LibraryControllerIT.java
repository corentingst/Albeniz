package com.theodo.Albeniz.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles="database")
public class LibraryControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetLibraryRoute() throws Exception{
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
    public void testGetSpecificMusicById() throws Exception {
        mockMvc.perform(get("/library/music/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'id': 1, 'title': 'Thriller', 'author': 'MJ'}"));
    }

    @Test
    public void testUnknownMusicIdRouteCall() throws Exception{
        mockMvc.perform(get("/library/music/1000"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetMusicBySearch() throws Exception{
        mockMvc.perform(get("/library/music?query=ll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{'id': 1, 'title': 'Thriller', 'author': 'MJ'}," +
                        "{'id': 3, 'title': 'Allumer le feu', 'author': 'Johnny'}" +
                        "]"));
    }
}
