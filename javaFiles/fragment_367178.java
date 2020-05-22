import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class TestProcessBuilder
{
    public static void main(String args[])
    {
        try
        {
            String threeCommands[] = 
                { "cmd", "/c", 
                    "dir", // prints out text 
                    "&&",
                    "ping", "127.0.0.1", "-n", "3", ">", "nul", // waits 3 seconds
                    "&&",
                    "dir" // prints out more text
                };
            ProcessBuilder builder = new ProcessBuilder(threeCommands);
            builder.directory(new File("C://"));
            builder.redirectErrorStream();

            Process subProcess = builder.start();

            // this reads from the subprocess's output stream
            BufferedReader subProcessInputReader = 
                new BufferedReader(new InputStreamReader(subProcess.getInputStream()));

            String line = null;
            while ((line = subProcessInputReader.readLine()) != null)
                System.out.println(line);

            subProcessInputReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}