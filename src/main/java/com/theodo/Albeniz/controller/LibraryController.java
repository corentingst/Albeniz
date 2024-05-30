package com.theodo.Albeniz.controller;

import com.theodo.Albeniz.Exceptions.UnknownMusicId;
import com.theodo.Albeniz.Service.LibraryService;
import com.theodo.Albeniz.dto.Tune;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @GetMapping(value = "/music")
    public Stream<Tune> getMusic(@RequestParam(required = false) String query) {
        if (query != null){
            return this.libraryService.getBySearch(query);
        } else {
            return this.libraryService.getAll();
        }
    }

    @GetMapping("music/{musicId}")
    public Tune getMusic(@PathVariable("musicId") int musicId) {
        return this.libraryService.getOne(musicId);
    }
}

