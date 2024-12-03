package y2024.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MulScanFunctions {

    static List<String> splitAbled(String input, boolean select){
        List<String> enabled = new ArrayList<>();
        List<String> disabled = new ArrayList<>();
        boolean enabledFlag = true;
        String disable = "don't()";
        String enable = "do()";
        StringBuilder token = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i)=='d'){
                if (enabledFlag){
                    if (
                            input.length()-i >5 &&
                            input.substring(i,i+7).equals(disable)
                    ){
                        enabledFlag = false;
                        i+=7;
                        enabled.add(token.toString());
                        token = new StringBuilder();
                    }
                }
                if (!enabledFlag){
                    if (
                            input.length()-i >2 &&
                            input.substring(i,i+4).equals(enable)
                    ){
                        enabledFlag = true;
                        i+=4;
                        disabled.add(token.toString());
                        token = new StringBuilder();
                    }
                }
            }
            token.append(input.charAt(i));
        }
        if (enabledFlag) {enabled.add(token.toString());}
        else {disabled.add(token.toString());}
        if (select) return enabled;
        else return disabled;
    }

    static List<String> regexTrim(String input){
        List<String> stringList = new ArrayList<>();
        Pattern pattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            stringList.add(matcher.group());
        }
        return stringList;
    }

    static List<Integer[]> parseOperandList(List<String> input){
        List<Integer[]> integerList = new ArrayList<>();
        for (String each : input){
            String raw = each.substring(4 , each.length()-1);
            String[] rawOperands = raw.split(",");
            Integer[] parseOperands =
                    {Integer.parseInt(rawOperands[0]),
                            Integer.parseInt(rawOperands[1])};
            integerList.add(parseOperands);
        }
        return integerList;
    }

    static Integer sumMultiplyOperandList(List<Integer[]> input){
        Integer runningSum = 0;
        for (Integer[] each : input){
            runningSum += (each[0]*each[1]);
        }
        return runningSum;
    }
}
