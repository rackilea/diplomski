import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountPairs {

    public static void main(String[] args) throws IOException {

        File input = new File("./pairs.txt");

        BufferedReader reader = new BufferedReader(new FileReader(input));

        String line;
        long pairsCount = 0;

        while ((line = reader.readLine()) != null) {
            String[] split = line.split(",");

            if(!split[0].equals(split[2])) {
                pairsCount++;
            }
        }

        System.out.println(pairsCount);
    }
}
