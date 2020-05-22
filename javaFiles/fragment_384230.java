import java.io.*;
import java.util.*;

public class SortTest {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Pass filename as argument!");
            System.exit(1);
        }

        Set<String> set = new HashSet<String>();
        File createdFile = new File("./outfile");
        createdFile.createNewFile();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(args[0])))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                set.add(line);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Fatal Error.",  ex);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(createdFile, true))) {
            for (String line : set) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }
}