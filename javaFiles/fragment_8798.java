package threadFile;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintReader implements Runnable
{
    @SuppressWarnings("unused")
    private final String taskName;

    final String file_name = "C:/Users/wigginsm/Desktop/Log.txt";

    public PrintReader(String name)
    {
        taskName = name;
    }
    public void run()
    {
        boolean loop = true;
        while(loop = true)
        try
        {
            FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while(line!=null)
            {
                count++;
                line=br.readLine();
            }
            FileInputStream fileIn = new FileInputStream(file_name);
            BufferedReader fileR = new BufferedReader(new InputStreamReader(fileIn));
            String strLine = null, tmp;
            while((tmp = fileR.readLine())!=null)
            {
                strLine = tmp;
            }
            String lastLine = strLine;
            System.out.println("Last entered line: " + lastLine + "\n" + "Total number of Lines: " + count);
            br.close();
            fileR.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}