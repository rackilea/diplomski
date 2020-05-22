import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String fileName = "table.txt";
        FileReader fr = null;

        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader reader = new BufferedReader(fr);
        String line = "";

        try {

            if ((line = reader.readLine()) != null) {

                // Match and capture the values we are looking for
                Pattern pattern = Pattern.compile("team=(\\w+),[\\w\\s,=]+goalsFor=(\\d+),");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {

                    // Output the results, you could store them in a 
                    // variable instead
                    System.out.println("Team name: " + matcher.group(1) +
                        ". Goals for: " + matcher.group(2));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}