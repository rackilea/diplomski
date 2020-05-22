import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Replace {
    public static void main(String[] args) {
        File folder = new File("C:/PathToYourFolder");
        File[] listOfFiles = folder.listFiles();
        for(File file : listOfFiles) {
            replaceText(file);
        }
    }

    public static void replaceText(File file) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();

            String replacedtext = oldtext.replaceAll("<eol> ", "");
            replacedtext = replacedtext.replaceAll("<eos> ", "");
            replacedtext = replacedtext.replaceAll(" \\.", ".");
            replacedtext = replacedtext.replaceAll(" \\,", ",");
            // replacedtext = replacedtext.replaceAll(" ", "");
            replacedtext = replacedtext.replaceAll(" \\'s", "'s");

            FileWriter writer = new FileWriter(file);
            writer.write(replacedtext);

            writer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}