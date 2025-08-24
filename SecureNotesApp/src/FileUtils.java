import java.io.*;
import java.util.ArrayList;

public class FileUtils {

    public static void saveNotesToFile(ArrayList<Note> notes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("notes.txt"))) {
            for (Note note : notes) {
                pw.println(note.sr + ";" + note.Title + ";" + note.Content);
            }
        } catch (IOException e) {
            System.out.println("Error saving notes.");
        }
    }

    public static void loadNotesFromFile(ArrayList<Note> notes) {
        try (BufferedReader br = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                notes.add(new Note(Integer.parseInt(parts[0]), parts[1], parts[2]));
            }
        } catch (IOException e) {
            System.out.println("No saved notes found.");
        }
    }
}
