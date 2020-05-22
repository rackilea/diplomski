import java.util.*;
import java.io.*;

// if run with "java maxfiles 10000", will create 10k files in the current folder
public class maxfiles
{
    static int count = 0;
    static List files = new ArrayList();

    public static void main(String args[]) throws Exception
    {
        for (int n = 0; n < Integer.parseInt(args[0]); n++) {
            File f = new File("file" + count++);
            //save ref, so not gc'ed
            files.add(new PrintStream(new FileOutputStream(f)));
        }
        Iterator it = files.iterator();
        while (it.hasNext()) {
            PrintStream out = ( PrintStream) it.next();
            out.println("foo");
            out.flush();
        }
        System.out.println("current files open: " + files.size());
    } //~main
}