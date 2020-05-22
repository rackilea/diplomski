import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class CountKeywords {

    public static void main(String args[]) {

        String[] theKeywords = { "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while" };

        // put each keyword in the map with value 0 
        Map<String, Integer> theKeywordCount = new HashMap<String, Integer>();
        for (String str : theKeywords) {
            theKeywordCount.put(str, 0);
        }

        FileReader fr;
        BufferedReader br;
        File file = new File(args[0]); // the filename is passed in as a String

        // attempt to open and read file
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String sLine;

            // read lines until reaching the end of the file
            while ((sLine = br.readLine()) != null) {

                // if an empty line was read
                if (sLine.length() != 0) {

                    // extract the words from the current line in the file
                    if (theKeywordCount.containsKey(sLine)) {
                        theKeywordCount.put(sLine, theKeywordCount.get(sLine) + 1);
                    }
                }
            }

        } catch (FileNotFoundException exception) {
            // Unable to find file.
            exception.printStackTrace();
        } catch (IOException exception) {
            // Unable to read line.
            exception.printStackTrace();
        } finally {
                br.close();
            }

        // count how many times each keyword was encontered
        int occurrences = 0;
        for (Integer i : theKeywordCount.values()) {
            occurrences += i;
        }

        System.out.println("\n\nTotal occurences in file: " + occurrences);
    }
}