import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {
        Map<String, String> animals = new HashMap<String, String>(); 
        BufferedReader in = new BufferedReader
            (new InputStreamReader(new FileInputStream("animals.txt")));
        String current_line;
        String[] splitted_strings = new String[1];
        while ((current_line = in.readLine()) != null){
            splitted_strings = current_line.split("\t");
            animals.put(splitted_strings[0], splitted_strings[1]);
        }
        for(Map.Entry entry : animals.entrySet()) 
            System.out.println(entry.getValue() + " " + entry.getKey());
    }
}