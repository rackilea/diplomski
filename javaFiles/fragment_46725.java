import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class SOPlayground {

    public static void main(String[] args) throws Exception {
        readAndPrint("/tmp/u-8.txt", Charset.forName("UTF-8"));
        readAndPrint("/tmp/u-16.txt", Charset.forName("UTF-16"));
        readAndPrint("/tmp/u-16le.txt", Charset.forName("UTF-16LE"));
        readAndPrint("/tmp/u-16be.txt", Charset.forName("UTF-16BE"));
    }

    private static void readAndPrint(String filePath, final Charset charset) throws IOException, FileNotFoundException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), charset));
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
    }
}