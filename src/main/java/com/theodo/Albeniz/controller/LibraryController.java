
package com.theodo.Albeniz.controller;

import com.theodo.Albeniz.Service.LibraryService;
import com.theodo.Albeniz.dto.Tune;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @GetMapping(value = "/music")
    public List<Tune> getMusic(@RequestParam(required = false) String query) {
        return libraryService.getMusic(query);
    }

    @GetMapping("music/{musicId}")
    public Tune getMusic(@PathVariable("musicId") int musicId) {
        return this.libraryService.getOne(musicId);
    }
}
