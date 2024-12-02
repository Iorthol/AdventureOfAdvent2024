package y2024.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadAdventFile{
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public ReadAdventFile(String filename){
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (inputStream == null) {
                System.err.println("File not found.");
                return;
            }
            BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while((line =buff.readLine())!=null) {
                    String[] slice = line.split("   ");
                    list1.add(Integer.parseInt(slice[0].trim()));
                    list2.add(Integer.parseInt(slice[1].trim()));
                }
        } catch (IOException e){
                System.err.println("Error reading file");
        }
    }
    List<Integer> getList1(){
        return list1;
    }
    List<Integer> getList2(){
        return list2;
    }
}
