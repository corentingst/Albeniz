package com.theodo.Albeniz.Service;

import com.theodo.Albeniz.dto.Tune;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("database")
public class InDatabaseLibraryService implements LibraryService {
    @Override
    public List<Tune> getMusic(String query) {
        return Collections.emptyList();
    }

    @Override
    public Tune getOne(int musicId) {
        return null;
    }
}