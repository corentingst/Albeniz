package com.theodo.Albeniz.Service;

import com.theodo.Albeniz.Exceptions.UnknownMusicId;
import com.theodo.Albeniz.dto.Tune;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LibraryService {

    private final static Map<Integer, Tune> LIBRARY = new HashMap<>();

    static {
        // ADD static values (temporary)
        LIBRARY.put(1, new Tune(1, "Thriller", "MJ"));
        LIBRARY.put(2, new Tune(2, "Bohemian Rhapsody", "Queen"));
        LIBRARY.put(3, new Tune(3, "Allumer le feu", "Johnny"));
    }

    public Tune getOne(int musicId) {
        if (LIBRARY.containsKey(musicId)) {
            // Mapping
            return LIBRARY.get(musicId);
        }
        throw new UnknownMusicId(String.format("Unknown music ID: %s", musicId));
    }
    public List<Tune> getMusic(String musicTitleQuery) {
        return musicTitleQuery!=null ? getBySearch(musicTitleQuery) : getAll();
    }
    public List<Tune> getAll() {return new ArrayList<Tune>(LIBRARY.values());}
    public List<Tune> getBySearch(String query) {
        Stream<Tune> searchResultStream = LIBRARY.values().stream().filter(element -> element.getTitle().contains(query));
        return searchResultStream.collect(Collectors.toList());
    }
}
