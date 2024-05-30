package com.theodo.Albeniz.controller;

import com.theodo.Albeniz.Exceptions.UnknownMusicId;
import com.theodo.Albeniz.dto.Tune;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {

    private final static Map<Integer, Tune> LIBRARY = new HashMap<>();

    static {
        // ADD static values (temporary)
        LIBRARY.put(1, new Tune(1, "Thriller", "MJ"));
        LIBRARY.put(2, new Tune(2, "Bohemian Rapsody", "Queen"));
        LIBRARY.put(3, new Tune(3, "Allumer le feu", "Johnny"));
    }

    @GetMapping(value = "/music")
    public Stream<Tune> getMusic(@RequestParam(required = false) String query) {
        if (query != null){
            return LIBRARY.values().stream().filter(element -> element.getTitle().contains(query));
        } else {
            return LIBRARY.values().stream();
        }

    }

    @GetMapping("music/{musicId}")
    public Tune getMusic(@PathVariable("musicId") int musicId) throws Exception {
        if (LIBRARY.containsKey(musicId)) {
            // Mapping
            return LIBRARY.get(musicId);
        }

        throw new UnknownMusicId(String.format("Unknown music ID: %s", musicId));
    }
}

