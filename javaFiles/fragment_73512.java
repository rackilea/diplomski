import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

...

String fileDir = "pathtodata";
try
{
    BufferedReader in = new BufferedReader(new InputStreamReader(
            new FileInputStream(fileDir), "UTF8"));

    Scanner scanner = new Scanner(in).useDelimiter("\\n");
    while (scanner.hasNext())
    {
        String line = scanner.next(); // This is your line
        String[] parts = line.split(delimiter);
        System.out.println(parts[0]);
    }
    scanner.close();
    in.close();
}
catch (Exception e)
{
    e.printStackTrace();
}