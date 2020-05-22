import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DummyReadFile {

    public static void main(String[] args) {

        BufferedReader br = null;

        try {

            String sCurrentLine;
            FileInputStream fin = new FileInputStream("C:/temp/test3.txt");
            br = new BufferedReader(new InputStreamReader(fin, "UTF-16LE"));
            //br = new BufferedReader(new FileReader("C:/temp/test3.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                /*if(sCurrentLine.contains("<"))
                {
                    System.out.println("==>>>"+sCurrentLine);
                }*/
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}