import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class StringUtilitiesFromFile  {
    public static void main(String[] args) throws IOException 
        {
              File file = new File("Auth.html");
        String string = FileUtils.readFileToString(file);  
                String And = string.replaceAll("\\(.*?\\)", "");  
        System.out.println(And);    
                System.out.println("");           
       }
}