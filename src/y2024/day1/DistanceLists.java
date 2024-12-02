package y2024.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistanceLists {
    public static void main(String[] args) {

        String filename = "y2024/day1/advent1input.txt";
        List<Integer>list1;
        List<Integer>list2;
        int totalLength = 0;
        ReadAdventFile adventReader = new ReadAdventFile(filename);
        list1 = adventReader.getList1();
        list2 = adventReader.getList2();
        Collections.sort(list1);
        Collections.sort(list2);


        for (int i = 0; i < list1.size(); i++){
            totalLength += Math.abs(list1.get(i)-list2.get(i));
        }
        System.out.println(totalLength);
    }
}

