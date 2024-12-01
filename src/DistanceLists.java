import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistanceLists {
    public static void main(String[] args) {

        String filename = "advent1input.txt";
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

class ReadAdventFile{
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

