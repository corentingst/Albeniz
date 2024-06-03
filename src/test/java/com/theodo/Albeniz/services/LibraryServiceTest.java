

package com.theodo.Albeniz.services;

import com.theodo.Albeniz.Service.InMemoryLibraryServiceMock;
import com.theodo.Albeniz.dto.Tune;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LibraryServiceTest {

    List<Tune> completeLibrary = Arrays.asList(
            new Tune(1, "Thriller", "MJ"),
            new Tune(2, "Bohemian Rhapsody", "Queen"),
            new Tune(3, "Allumer le feu", "Johnny")
    );

    List<Tune> searchedLibrary = Arrays.asList(
            new Tune(1, "Thriller", "MJ"),
            new Tune(3, "Allumer le feu", "Johnny")
    );



    @Test
    public void testGetAll() throws Exception{
        InMemoryLibraryServiceMock inMemoryLibraryServiceMock = new InMemoryLibraryServiceMock();
        Assertions.assertEquals(completeLibrary, inMemoryLibraryServiceMock.getMusic(null));
    }

    @Test
    public void testGetBySearch() throws Exception{
        InMemoryLibraryServiceMock inMemoryLibraryServiceMock = new InMemoryLibraryServiceMock();
        Assertions.assertEquals(searchedLibrary, inMemoryLibraryServiceMock.getMusic("ll"));
    }
}
