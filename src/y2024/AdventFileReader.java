package y2024;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AdventFileReader {
    public static List<String> readFileToStringList(String fileName){
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(fileName)));
        } catch (IOException e){
            System.err.println("Error reading file.");
            return null;
        }
    }

    public static String readFileToString(String fileName){
        try {
            return Files.readString(Paths.get(fileName));
        } catch (IOException e){
            System.err.println("Error reading file.");
            return null;
        }
    }

    public static List<List<Integer>> readStringListToIntegerTable(List<String> input){
        try {
            List<List<Integer>> table = new ArrayList<>();
            for (String line : input) {
                String[] parts = line.split("\\s+");
                List<Integer> row = new ArrayList<>();

                for (String part : parts) {
                    row.add(Integer.parseInt(part.trim()));
                }
                table.add(row);
            }
            return table;
        } catch (NullPointerException e){
            System.err.println("Error reading data.");
            return null;
        }
    }
}
