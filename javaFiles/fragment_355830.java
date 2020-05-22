import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class Save
{
    public static void main(String[] args)
    {
        File file = new File("save.txt");
        try {
            file.mkdirs();
            file.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            PrintWriter pw = new PrintWriter(file);
            pw.println("Hello World");
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}