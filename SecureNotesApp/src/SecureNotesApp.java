import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class SecureNotesApp {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Note> notes = new ArrayList<>();        // used to store text notes
    static int counter = 1;

    public static void addNote() {
        try {
            System.out.print("Enter title: ");
            String title = sc.nextLine();
            System.out.print("Enter content: ");
            String content = sc.nextLine();

           
            String encryptedContent = CryptoUtils.encrypt(content);        // Encrypting before storing

            notes.add(new Note(counter++, title, encryptedContent));
            saveNotesToFile();
            System.out.println("Note added successfully!");
        } catch (Exception e) {
            System.out.println("Error encrypting note: " + e.getMessage());
        }
    }

    public static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
            return;
        }
        for (Note note : notes) {
            try {
                String decrypted = CryptoUtils.decrypt(note.Content);
                System.out.println(note.sr + ". " + note.Title + " - " + decrypted);
            } catch (Exception e) {
                System.out.println("Error decrypting note. Raw content: " + note.Content);
            }
        }
    }

    public static void updateNote() {
        System.out.print("Enter the ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        for (Note note : notes) {
            if (note.sr == id) {
                System.out.print("Enter new title: ");
                note.Title = sc.nextLine();
                System.out.print("Enter new content: ");
                String newContent = sc.nextLine();
                try {
                    note.Content = CryptoUtils.encrypt(newContent);
                } catch (Exception e) {
                    System.out.println("Error encrypting updated note.");
                }
                System.out.println("Note updated successfully.");
                return;
            }
        }
        System.out.println("Note not found.");
    }

    public static void deleteNote() {
        System.out.print("Enter ID to delete the note: ");
        int sr = sc.nextInt();
        sc.nextLine();
        notes.removeIf(note -> note.sr == sr);
        System.out.println("Note deleted successfully.");
    }

    public static void saveNotesToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("notes.txt"))) {
            for (Note note : notes) {
                pw.println(note.sr + ";" + note.Title + ";" + note.Content);
            }
        } catch (IOException e) {
            System.out.println("Error saving notes: " + e.getMessage());
        }
    }

    public static void loadNotesFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";", 3);
                if (parts.length == 3) {
                    notes.add(new Note(Integer.parseInt(parts[0]), parts[1], parts[2]));
                }
            }
            if (!notes.isEmpty()) {
                counter = notes.get(notes.size() - 1).sr + 1;
            }
        } catch (IOException e) {
            System.out.println("No saved notes found, starting fresh.");
        }
    }

    public static void main(String[] args) {
        loadNotesFromFile();
        while (true) {
            System.out.println("\n1. Add Note   2. View Notes   3. Update   4. Delete   5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                addNote();
            } else if (choice == 2) {
                viewNotes();
            } else if (choice == 3) {
                updateNote();
                saveNotesToFile();
            } else if (choice == 4) {
                deleteNote();
                saveNotesToFile();
            } else {
                break;
            }
        }
    }
}
