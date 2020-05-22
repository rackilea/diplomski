import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("abc.txt")); 
        String line; 
        while((line = in.readLine()) != null) 
        {
            System.out.println(line.substring(0,line.lastIndexOf("--@")));
        }

        in.close();
    }
}