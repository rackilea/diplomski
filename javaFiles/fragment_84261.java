import java.io.IOException;
import org.junit.Test;

public class FileTest {
    @Test
    public void testFile(){
        File f;
        try {
            f = File.open("File.java");
            for(String s : f){
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadAndWriteFile(){
        File from;
        File to;
        try {
            from = File.open("File.java");
            to = File.open("Out.txt", "w");
            for(String s : from){           
                to.write(s + System.getProperty("line.separator"));
            }
            to.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }   
    }
}