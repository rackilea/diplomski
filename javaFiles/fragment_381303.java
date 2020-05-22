import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class ReaderWriter {
    public static void main(String[] args) {
        try {
            String content = "Hamamélis. Written: " + new java.util.Date();

            File file = new File("some_text.txt");

            // Create file if not already existent. 
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream( file );
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter( fileOutputStream, "UTF-8" );
            BufferedWriter bufferedWriter = new BufferedWriter( outputStreamWriter );
            bufferedWriter.write( content );
            bufferedWriter.close();

            System.out.println("ReaderWriter 'main' method is done. " + new java.util.Date() );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}