import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("someFile"));
        try {
            String line = br.readLine();
            while (line != null) {
                if(line.contains("String 1")) {
                    // ...
                } else if (line.contains("String 2")) {
                    // ...
                }               
                line = br.readLine();
            }       
        } finally {
            br.close();
        }
    }
}