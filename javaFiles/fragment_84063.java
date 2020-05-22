import java.io.*;

public class IOUtilities
{
    public static int getLineCount (String filename) throws FileNotFoundException, IOException
    {
        LineNumberReader lnr = new LineNumberReader (new FileReader (filename));
        while ((lnr.readLine ()) != null) {}

        return lnr.getLineNumber ();
    }
}