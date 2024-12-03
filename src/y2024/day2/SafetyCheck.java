package y2024.day2;

import java.util.ArrayList;
import java.util.List;

public class SafetyCheck {
    public static boolean dampenCheck(List<Integer> input){
        if (safetyCheck(input)) return true;
        for (int i = 0; i < input.size(); i++){
            if (safetyCheck(dropOne(input, i))) return true;
        }
        return false;
    }

    public static List<Integer> dropOne(List<Integer> input, int index){
        List<Integer> reducedReport = new ArrayList<>(input);
        reducedReport.remove(index);
        return reducedReport;
    }

    public static boolean safetyCheck(List<Integer> input){
        if (input.isEmpty() || input.getFirst().equals(input.get(1))){
            return false;
        }
        boolean grade = input.getFirst() < input.get(1);

        for (int i = 0; i < input.size()-1; i++){
            int current = input.get(i);
            int next = input.get(i+1);
            int shift = Math.abs(next-current);
            if (shift < 1 || shift > 3){
                return false;
            }
            if (grade && next < current){
                return false;
            }
            if (!grade && next > current){
                return false;
            }
        }
        return true;
    }
}
