import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class createfile
{
    public static void main(String[] args) throws IOException
   {

     int[] numbers = {1,2,3};
     for (int item : numbers) 
     {
        String key = "file" + item;
        File file = File.createTempFile(key,".txt",new File("c:\\"));

        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("01234567890112345678901234\n");
        writer.write("!@#$%^&*()-=[]{};':',.<>/?\n");
        writer.write("01234567890112345678901234\n");
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.close();
     }  
   }
}