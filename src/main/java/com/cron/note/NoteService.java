package com.cron.note;

import com.cron.note.Note;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class NoteService {
    private Map<Long, Note> notes = new HashMap<>();

    public Note add(Note note) {
        Long id = note.getId();
        if (notes.containsKey(id)) {
            throw new IllegalArgumentException("Note already exists");
        } else {
            id = getMaxId() + 1;
            note.setId(id);
            notes.put(id, note);
        }
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note not found");
        } else {
            notes.remove(id);
        }
    }

    public void update(Note note) {
        Long id = note.getId();
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note not found");
        } else {
            notes.put(id, note);
        }
    }

    public List<Note> listAll() {
        return notes.values().stream().toList();
    }

    public Note getById(Long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note not found");
        }
        return notes.get(id);
    }

    private Long getMaxId() {
        return notes.keySet().stream().max(Long::compareTo).get();
    }
}

