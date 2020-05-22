import java.io.*;
import java.util.*;

public class ReadFile
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter file name");
        String fileName = br.readLine();
        File file = new File(fileName);
        if(file.length() == 0)
        {
            System.out.println("File is empty");
        }
        else
        {
            BufferedReader fr = new BufferedReader(new FileReader(file));
            ArrayList<String> words = new ArrayList<String>();
            String[] line;
            String str;
            while((str=fr.readLine()) != null)
            {
                line = str.split(" ");
                for(String word : line)
                    words.add(word);
            }

            // Printing the content of words
            for(String word : words)
                System.out.println(word);
        }
    }
}