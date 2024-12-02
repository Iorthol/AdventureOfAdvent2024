package y2024.day1;

import java.util.Collections;
import java.util.List;

public class CopiesList {
    public static void main(String[] args) {
        String filename = "y2024/day1/advent1input.txt";
        List<Integer> list1;
        List<Integer>list2;
        ReadAdventFile adventReader = new ReadAdventFile(filename);
        list1 = adventReader.getList1();
        list2 = adventReader.getList2();
        Collections.sort(list1);
        Collections.sort(list2);
        int bigScore = 0;

        for (Integer each1 : list1){
            Integer value = each1;
            Integer multiplier = 0;
            for (Integer each2 : list2){
                if (each1.equals(each2)){
                    multiplier++;
                }
            }
            if (!multiplier.equals(0)) {
                System.out.println(value + " " + multiplier);
                bigScore += value * multiplier;
            }
        }
        System.out.println(bigScore);
    }
}
