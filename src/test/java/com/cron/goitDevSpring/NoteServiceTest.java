package com.cron.goitDevSpring;

import com.cron.note.Note;
import com.cron.note.NoteRepository;
import com.cron.note.NoteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    private NoteService noteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        noteService = new NoteService(noteRepository);
    }

    @Test
    void testAddNote() {
        // Arrange
        Note note = new Note();
        note.setTitle("Test Title");
        note.setContent("Test Content");

        Mockito.when(noteRepository.save(Mockito.any(Note.class))).thenReturn(note);

        // Act
        Note result = noteService.add(note);

        // Assert
        Assertions.assertEquals(note, result);
        Assertions.assertNull(result.getId()); // Note id should be null
        Mockito.verify(noteRepository, Mockito.times(1)).save(note);
    }

    @Test
    void testDeleteNoteById() {
        // Arrange
        long noteId = 1L;

        // Act
        noteService.deleteById(noteId);

        // Assert
        Mockito.verify(noteRepository, Mockito.times(1)).deleteById(noteId);
    }

    @Test
    void testUpdateNote() {
        // Arrange
        Note note = new Note();
        note.setId(1L);
        note.setTitle("Updated Title");
        note.setContent("Updated Content");

        Mockito.when(noteRepository.save(Mockito.any(Note.class))).thenReturn(note);

        // Act
        noteService.update(note);

        // Assert
        Mockito.verify(noteRepository, Mockito.times(1)).save(note);
    }

    @Test
    void testListAllNotes() {
        // Arrange
        List<Note> notes = new ArrayList<>();
        notes.add(new Note());
        notes.add(new Note());

        Mockito.when(noteRepository.findAll()).thenReturn(notes);

        // Act
        List<Note> result = noteService.listAll();

        // Assert
        Assertions.assertEquals(notes, result);
        Mockito.verify(noteRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testGetNoteById() {
        // Arrange
        long noteId = 1L;
        Note note = new Note();
        note.setId(noteId);
        Mockito.when(noteRepository.findById(noteId)).thenReturn(Optional.of(note));

        // Act
        Note result = noteService.getById(noteId);

        // Assert
        Assertions.assertEquals(note, result);
        Mockito.verify(noteRepository, Mockito.times(1)).findById(noteId);
    }

    @Test
    void testGetNoteByInvalidId() {
        // Arrange
        long invalidNoteId = 100L;
        Mockito.when(noteRepository.findById(invalidNoteId)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            noteService.getById(invalidNoteId);
        });
        Mockito.verify(noteRepository, Mockito.times(1)).findById(invalidNoteId);
    }
}