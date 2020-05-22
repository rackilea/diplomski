import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader inp;
    public static BufferedWriter out;

    public static void print(String s) {
    System.out.println(s);
    }

    public static String pipe(String msg) {
    String ret;

    try {
        out.write( msg + "\n" );
        out.flush();
        ret = inp.readLine();
        return ret;
    }
    catch (Exception err) {

    }
    return "";
    }



    public static void main(String[] args) {

    String s;
    String cmd = "c:\\programs\\python\\python.exe d:\\a.py";

    try {

        print(cmd);
        print(System.getProperty("user.dir"));
        Process p = Runtime.getRuntime().exec(cmd);

        inp = new BufferedReader( new InputStreamReader(p.getInputStream()) );
        out = new BufferedWriter( new OutputStreamWriter(p.getOutputStream()) );

        print( pipe("AAAaaa") );
        print( pipe("RoteM") );

        pipe("quit")
        inp.close();
        out.close();
    }

    catch (Exception err) {
        err.printStackTrace();
    }
    }
}