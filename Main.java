package com.example.notetaking;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        NoteManager noteManager = new NoteManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Note-taking App!");

        do {
            System.out.println("\nEnter a command (create, read, update, delete, exit): ");
            command = scanner.nextLine();

            switch (command) {
                case "create":
                    System.out.print("Enter note content: ");
                    String content = scanner.nextLine();
                    noteManager.createNote(content);
                    break;
                case "read":
                    noteManager.readNotes();
                    break;
                case "update":
                    System.out.print("Enter note ID to update: ");
                    int idToUpdate = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new content: ");
                    String newContent = scanner.nextLine();
                    noteManager.updateNote(idToUpdate, newContent);
                    break;
                case "delete":
                    System.out.print("Enter note ID to delete: ");
                    int idToDelete = Integer.parseInt(scanner.nextLine());
                    noteManager.deleteNote(idToDelete);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}
