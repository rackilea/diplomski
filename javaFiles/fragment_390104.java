package fileread;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {


public static void main(String[] args) {
    Set<String> uniqueLines = new HashSet<String>();
    Set<String> duplicatedLines = new HashSet<String>();
    try{
        FileInputStream fstream=new FileInputStream("C:/Users/kiran/Desktop/text.txt");
        DataInputStream in=new DataInputStream (fstream);
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        String str;
        while((str=br.readLine())!=null){
            if (uniqueLines.contains(str)) {
                if (!duplicatedLines.contains(str)) {
                    duplicatedLines.add(str);
                    System.out.println(str);
                }
            } else {
                uniqueLines.add(str);
            }
        }
        in.close();
    }
    catch(Exception e){
        System.err.println(e);
    }
}

}