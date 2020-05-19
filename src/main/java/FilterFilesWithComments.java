import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilterFilesWithComments {

    public static void main(String[] args) throws IOException {

        long relevantFileCounter = 0;

        File dir = new File("/Users/lracki/Desktop/diplomski/filtered/javaFiles");
        File[] directoryListing = dir.listFiles();

        File dir2 = new File("/Users/lracki/Desktop/diplomski/filtered/filesWithComments");
        File[] directoryListing2 = dir2.listFiles();

        List<String> filesWithComments = new ArrayList<>();

        if (directoryListing != null) {
            for (File child : directoryListing) {
                BufferedReader br = new BufferedReader(new FileReader(child));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.contains("//") || line.contains("/*")) {
                        filesWithComments.add(child.getName());
                        break;
                    }
                }
                br.close();
            }
        }

        for (String file : filesWithComments) {
            Files.move(Paths.get("/Users/lracki/Desktop/diplomski/filtered/javaFiles/" + file), Paths.get("/Users/lracki/Desktop/diplomski/filtered/filesWithComments/" + file));
            ++relevantFileCounter;
        }

        System.out.println("Files moved :" + relevantFileCounter);

        System.out.println("With comments : " + directoryListing.length);
        System.out.println("Without comments : " + directoryListing2.length);
    }
}
