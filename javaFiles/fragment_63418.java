import java.util.*;
import java.util.regex.*;
import java.lang.*;
import java.io.*;

class test
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader in  = new BufferedReader(new FileReader(new File("data")));
        String line="";
        Pattern p=Pattern.compile("href\\s*=\\s*(?:\"|').*municipalite/[^>]*>(?:<.*>)*([^<]*)<.*$");
        while ((line = in.readLine()) != null)
        {
            Matcher m=p.matcher(line);
            while(m.find())
                System.out.println(m.group(1)); 
        }
        in.close();
    }
}