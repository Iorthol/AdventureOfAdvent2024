package y2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AdeventFileReader {
    public static List<String> readFile(String fileName){
        try {
            return Files.readAllLines(Paths.get("./" + fileName));
        } catch (IOException e){
            System.err.println("Error reading file.");
            return null;
        }
    }
}
