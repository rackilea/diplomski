import java.io.BufferedReader;
import java.io.FileReader;


public class Vehicle {
    public static void main(String[]args) throws Exception
    {
        FileReader file = new FileReader("C:/Users/Aaron/Documents/java/car_file.txt");
        BufferedReader reader = new BufferedReader(file);
        String text = "";
        String line = reader.readLine() +"\n";
        while (line!= null)
        {
            text += line;
            line = reader.readLine() +"\n";
        }

        System.out.println(text);

        String lines[] = text.split("\n");
        int count = lines.length;
        System.out.println(count);

        for(String line : lines) {
            String words[] = line.split(",");
            <<do something with words array>>
        }
    }
}