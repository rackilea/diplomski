import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class A2Q2 {

    public static final int MAX_CHARS_PER_LINE = 40;

    public static void main(String[] args) {
        printFile();
    }

    public static void printFile() {

        BufferedReader fileIn = null;
        FileReader fileReaderIn = null;
        String inputLine;
        int lengthOfLine;
        int newLineCount;
        StringBuilder sb = new StringBuilder(); 

        try {
            fileReaderIn = new FileReader("A2Q2in.txt");
            fileIn = new BufferedReader(fileReaderIn);

            // read paragraph line by line
            while ((inputLine = fileIn.readLine()) != null) {

                // counter for iteration, set on each iteration for new line from paragraph 
                int ctr = 0;
                // append line to string builder object
                sb.append(inputLine);
                lengthOfLine = sb.length();

                // identifies how many newline characters to be added in the line
                newLineCount = lengthOfLine / MAX_CHARS_PER_LINE;

                // if newCount > 0 is true, signifies that line needs to be broken to 40 chars
                if(newLineCount > 0) {

                    while(ctr < newLineCount) {
                        // insert newline character at 40th index from last newline character 
                        sb.insert((MAX_CHARS_PER_LINE+(MAX_CHARS_PER_LINE*ctr)+ctr), "\n");
                        ctr++;
                    }
                    System.out.print(sb.substring(0, (MAX_CHARS_PER_LINE*newLineCount)+ctr));

                    // delete the printed string and keeping the left over to be appended by next line 
                    sb.delete(0, ((MAX_CHARS_PER_LINE*newLineCount)+ctr));
                }
            }
            // print the remaining string left in the builder object.
            System.out.print(sb.toString());
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        finally {

            if(fileIn != null) {
                try {
                    fileIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileReaderIn != null) {
                try {
                    fileReaderIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}