package com.example.notetaking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NoteStorage {
		
	private static final String FILE_NAME = "notes.txt";

    public void saveNotes(List<Note> notes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Note note : notes) {
                writer.write(note.getId() + "|" + note.getContent());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving notes: " + e.getMessage());
        }
    }

    public List<Note> loadNotes() {
        List<Note> notes = new ArrayList<>();
        File file = new File(FILE_NAME);
        
        if (!file.exists()) {
            return notes; // Return empty list if no file exists
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    int id = Integer.parseInt(parts[0]);
                    String content = parts[1];
                    notes.add(new Note(id, content));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading notes: " + e.getMessage());
        }
        
        return notes;
    }
}
