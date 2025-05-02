import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile(List<String> content, String filePath) {
        try {
            Files.write(Path.of(filePath), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*public static List<String> readFileIO(String filePath) {
        List<String> allLines = new ArrayList<>();
        try (FileReader input = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(input)) {

            while (reader.ready()) {
                String text = reader.readLine().toLowerCase();
                allLines.add(text);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allLines;
    }

    public static void writeFileIO(List<String> content, String filePath) {
        try (FileWriter output = new FileWriter(filePath);
             BufferedWriter writer = new BufferedWriter(output)) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
