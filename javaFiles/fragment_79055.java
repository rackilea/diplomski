import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class YourClass {

    public static void main(String[] args) {

        // Path to the file being converted
        String infile = "C:/Users/.../test.txt"; // Some absolute path
        // Path to the destination output file
        String outfile = "C:/Users/.../test.csv"; // Some absolute path

        try {           

            // Read all rows from the infile
            List<String> rows = Files.readAllLines(Paths.get(infile), Charset.forName("UTF-8"));
            // List of new rows to write to the outfile
            ArrayList<String> nrows = new ArrayList<String>();

            // Enumerate rows
            for (String row : rows) {
                // Remove any word followed by any number of spaces and
                // an equals sign followed by any number of spaces
                String nrow = row.replaceAll("[\\w\\s]+\\s*=\\s*", "");
                // Append edited row to new rows
                nrows.add(nrow);
            }               

            // Get file descriptor
            Path file = Paths.get(outfile);
            // Write rows to outfile
            Files.write(file, nrows, Charset.forName("UTF-8"));

            // Update G/TUI
            System.out.println("CSV Written");

        }       
        catch (IOException e) {
            // You should catch specific exceptions
            e.printStackTrace();           
        }       

    }

}