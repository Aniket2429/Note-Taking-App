package com.example.notetaking;

import java.util.ArrayList;
import java.util.List;

public class NoteManager {
	 private List<Note> notes;
	    private int currentId;

	    public NoteManager() {
	        this.notes = new ArrayList<>();
	        this.currentId = 1; // Start IDs from 1
	    }

	    public void createNote(String content) {
	        Note note = new Note(currentId++, content);
	        notes.add(note);
	        System.out.println("Note created: " + note);
	    }

	    public void readNotes() {
	        if (notes.isEmpty()) {
	            System.out.println("No notes available.");
	            return;
	        }
	        for (Note note : notes) {
	            System.out.println(note);
	        }
	    }

	    public void updateNote(int id, String newContent) {
	        for (Note note : notes) {
	            if (note.getId() == id) {
	                note.setContent(newContent);
	                System.out.println("Note updated: " + note);
	                return;
	            }
	        }
	        System.out.println("Note not found.");
	    }

	    public void deleteNote(int id) {
	        notes.removeIf(note -> note.getId() == id);
	        System.out.println("Note with ID " + id + " deleted.");
	    }
}
