import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SoSample {

public static void main(String[] args) {
    Properties properties = new Properties();
    InputStream input = null;
    try {
        input = new FileInputStream("sample.properties");
        properties.load(input);
        String dirPath = (String)properties.get("dirpath");
        System.out.println(dirPath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}