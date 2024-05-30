package com.theodo.Albeniz.Service;

import com.theodo.Albeniz.Exceptions.UnknownMusicId;
import com.theodo.Albeniz.dto.Tune;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class LibraryService {

    private final static Map<Integer, Tune> LIBRARY = new HashMap<>();

    static {
        // ADD static values (temporary)
        LIBRARY.put(1, new Tune(1, "Thriller", "MJ"));
        LIBRARY.put(2, new Tune(2, "Bohemian Rapsody", "Queen"));
        LIBRARY.put(3, new Tune(3, "Allumer le feu", "Johnny"));
    }
    public Stream<Tune> getAll() {
        return LIBRARY.values().stream();
    }
    public Stream<Tune> getBySearch(String query) {
        return LIBRARY.values().stream().filter(element -> element.getTitle().contains(query));
    }
    public Tune getOne(int musicId) {
        if (LIBRARY.containsKey(musicId)) {
            // Mapping
            return LIBRARY.get(musicId);
        }
        throw new UnknownMusicId(String.format("Unknown music ID: %s", musicId));
    }
}
