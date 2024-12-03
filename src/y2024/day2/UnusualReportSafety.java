package y2024.day2;

import y2024.AdventFileReader;
import java.util.List;

public class UnusualReportSafety {
    public static void main(String[] args) {
        String filename = "src/y2024/day2/input-advent2024-day2.txt";
        List<String> fileData;
        List<List<Integer>> reports;
        fileData = AdventFileReader.readFileToList(filename);
        reports  = AdventFileReader.readStringListToIntegerTable(fileData);

        int safeReportCounter = 0;

        try{
            for (List<Integer> each : reports){
                if(SafetyCheck.dampenCheck(each)){
                    safeReportCounter++;
                }
            }
        } catch (NullPointerException e){
            System.err.println("Null Data Error.");
        }
        System.out.println(safeReportCounter);
    }
}
