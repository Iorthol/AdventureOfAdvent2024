package y2024.day3;

import y2024.AdventFileReader;

import java.util.List;

import static y2024.day3.MulScanFunctions.*;

public class MulScan {
    public static void main(String[] args) {
        String fileName = "src/y2024/day3/input-advent2024-day3.txt";
        String fileData = AdventFileReader.readFileToString(fileName);


        List<String> regexData;
        List<Integer[]> operandData;
        Integer sum;
        regexData = regexTrim(fileData);
        operandData = parseOperandList(regexData);
        sum = sumMultiplyOperandList(operandData);
        System.out.println("Sum of mults = " + sum);


        Integer runningSum = 0;
        List<String> doData = splitAbled(fileData, true);
        for (String each : doData){
            runningSum += sumMultiplyOperandList(parseOperandList(regexTrim(each)));
        }
        System.out.println("Sum of enabled mults = " + runningSum);
    }
}

