import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class DoWork {
    public static void main (String[] args) throws IOException{
        String[] myStringArray = {"The", "theory", "of", "thermon"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String searchTerm = br.readLine();
        int counter=0;
        for (String s: myStringArray) {
            if (s.contains(searchTerm)){
                counter++;
            }
        }
        System.out.println(counter);
    }
}