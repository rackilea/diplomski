import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteIntoFile {

    public static void main(String[] args) {
        String multilineString = "This is line 1\nthis is line 2\nthis is last line";
           try {
               FileWriter fileWriter = new FileWriter("multiline.txt", true);

               BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
               bufferedWriter.write(multilineString + "\n");
               bufferedWriter.flush();
               bufferedWriter.close();
               fileWriter.close();
           } 
           catch(IOException e) {
               e.printStackTrace();
           }

    }

}