package com.theodo.Albeniz.Service;

import com.theodo.Albeniz.dto.Tune;

import java.util.List;

public interface LibraryService {
    Tune getOne(int musicId);
    List<Tune> getMusic(String musicTitleQuery);
}
