import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MapScanner {

    public static void main(String[] args) throws IOException {
        //Reading entries
        Scanner scanner = new Scanner(new File("data"));
        scanner.useDelimiter(Pattern.compile(",(\n)?"));

        final Map<String, Integer> entries = new HashMap<>();
        while(scanner.hasNext()){
            final String entry = scanner.next();
            final String[] entrySplited = entry.split(":");

            entries.put(entrySplited[0].trim(), new Integer(entrySplited[1].trim()));
        }

        for(String key : entries.keySet()){
            System.out.println(key + " : " + entries.get(key));
        }

        scanner.close();

        //Adding a new entry in memory
        entries.put("pizza", new Integer(5));

        //Saving all entries in the data file
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("data"))){
            for(String key : entries.keySet()){
                bw.write(key + " : " + entries.get(key) + ",");
                bw.flush();
                bw.newLine();
            }   
        }
    }
}