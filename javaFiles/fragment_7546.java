import java.io.*;
import java.util.*;
public class ExampleClass1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("trainnames.txt"));
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        while (scanner.hasNextLine()) {
            String[] columns = scanner.nextLine().split(";");
            map.put(columns[0].trim(), columns[1].trim());
        }
        scanner.close();
        System.out.println("******** map is: " + map);
        File file = new File("onn.csv"); // output file
        FileWriter fileWriter = new FileWriter(file);
        scanner = new Scanner(new FileReader("train.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.charAt(0) == '>') {
                //System.out.println("==== line: [" + line + ']');      
                String num = map.get(line);
                no(num, fileWriter);
            }
        }
        scanner.close();
        fileWriter.close();
    }

    public static void no(String num, FileWriter fileWriter) throws IOException {
        fileWriter.append(num + ',' + System.getProperty("line.separator"));
        System.out.println(num);                                        
    }
}