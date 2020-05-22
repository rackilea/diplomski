import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Address {

    public static void main(String[] args) throws IOException {

        // Complete File Path
        File dir =
            new File("\\..\\..\\Test.html");

        // Convert File Data As String
        String data =
            new String(
                Files.readAllBytes(Paths
                    .get(dir
                        .getAbsolutePath())));

        // For Loop to get all the <address> tags in the file.
        for (int index = data.indexOf("<address"); index >= 0;) {

            // Start Index
            int startIndex = data.indexOf(">", index + 1);
            ++startIndex;

            // End Index
            int indexOfEnd = data.indexOf("</address>", startIndex + 1);

            String attributesString = data.substring(startIndex, indexOfEnd);
            // Replace below line with desired logic with calling trim() on the String attributesString
            System.out.println(attributesString);

            // Next Address will be after the end of first address
            index = data.indexOf("<address", indexOfEnd + 1);
        }
    }
}