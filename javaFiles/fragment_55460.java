package org.sample;
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.Reader; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

public class FileTokenizer 
{ 
    private static final String DEFAULT_DELIMITERS = "< , { } >"; 
 // private static final String DEFAULT_TEST_FILE = "trans1.txt"; 

    public List<String> tokenize(Reader reader) throws IOException 
    { 
        List<String> tokens = new ArrayList<String>(); 

        BufferedReader br = null; 

        try 
        { 
            int i = 0; 
            br = new BufferedReader(reader); 
            Scanner scanner = new Scanner(br); 
            while (scanner.hasNext()) 
            { 

                StringTokenizer st = new StringTokenizer(scanner.next(), DEFAULT_DELIMITERS, true); 
                while (st.hasMoreElements()) 
                { 
                    String[] t = new String[200]; 
                    // tokens.add(st.nextToken()); 
                    //    t[i] = st.nextToken();  

                    System.out.println(t[i]); 

                    i++;                                       
                } 
            } 
        } 
        finally 
        { 
            close(br); 
        } 

        return tokens; 
    } 

    public static void close(Reader r) 
    { 
        try 
        { 
            if (r != null) 
            { 
                r.close(); 
            } 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
    } 

   public static void main(String[] args) 
    { 
        try 
        { 
          //  String fileName = ((args.length > 0) ?  args[0] : DEFAULT_TEST_FILE); 
            FileReader fileReader = new FileReader(new File("c:\\DevTest\\1.txt")); 
            FileTokenizer fileTokenizer = new FileTokenizer(); 
            List<String> tokens = fileTokenizer.tokenize(fileReader); 
            //System.out.println(tokens); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
    } 
}