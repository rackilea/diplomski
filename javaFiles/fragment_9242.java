import java.io.*;
import java.util.Scanner;


public class ScanXan {
    public static void main(String[] args) throws IOException {
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader("yourFile.txt")));
            while (s.hasNext())
            {
               String str = s.next(); 
                char[] myChar = str.toCharArray();
                // do something
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }