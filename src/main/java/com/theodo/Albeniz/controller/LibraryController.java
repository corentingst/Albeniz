package com.theodo.Albeniz.controller;

import com.theodo.Albeniz.dto.Tune;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {
    @GetMapping(value = "/music")
    public Collection<Tune> getMusic() {
        return Arrays.asList(new Tune("Thriller", "MJ"), new Tune("Bohemian Rapsody", "Queen"), new Tune("Allumer le feu", "Johnny"));
    }

}
