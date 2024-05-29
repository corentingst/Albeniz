package com.theodo.Albeniz.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {
    @GetMapping(value = "/music")
    public Collection<String> getMusic() {
        return Arrays.asList("Thriller", "Bohemian Rapsody", "Allumer le feu");
    }
}
