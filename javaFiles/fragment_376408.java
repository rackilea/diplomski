import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // the path to your source file as a String
        String fileLocation = "Y:\\our\\path\\to\\lain.csv";
        // the path to your source file as a Path object (java.nio)
        Path filePath = Paths.get(fileLocation);
        // a list of Strings for the new lines, those with a comment separated by |
        List<String> updatedLines = new ArrayList<String>();

        try {
            // read all the lines of the csv source file into a list
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.ISO_8859_1);

            System.out.println("————————————————————————————————————————————————————————————————");

            // print each line just to see if everything is properly read (the java 8 way)
            lines.forEach(line -> {
                System.out.println(line);
            });

            System.out.println("————————————————————————————————————————————————————————————————");

            // add a comment to each line and store it in the updatedLines 
            lines.forEach(line -> {
                /*
                 * TODO add some line-depending comment creation logic here,
                 * this just adds "a comment" to every line
                 */
                updatedLines.add(line + "|" + "a comment");
            });

            // print the updated lines
            updatedLines.forEach(updatedLine -> {
                System.out.println(updatedLine);
            });

            System.out.println("————————————————————————————————————————————————————————————————");

            // create a new file
            String updatedFileLocation = "Y:\\our\\path\\to\\lain_updated.csv";
            Path updatedFilePath = Paths.get(updatedFileLocation);
            Files.createFile(updatedFilePath);

            // write the updated lines to a new csv file
            Files.write(updatedFilePath, updatedLines,
                    StandardOpenOption.TRUNCATE_EXISTING);

            // final check: read the new file and print its content:
            Files.readAllLines(updatedFilePath).forEach(writtenUpdatedLine -> {
                System.out.println(writtenUpdatedLine);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}