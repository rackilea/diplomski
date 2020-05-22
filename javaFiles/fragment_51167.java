import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {
public static void main(String[] args) throws IOException {
    final ReadFile readFile = new ReadFile();
    readFile.read("Windows-1252");
    readFile.read("UTF-8");
}

private void read(final String charsetName) throws IOException {
    //Java 8 version
    Files.lines(Paths.get("myFile.txt"), Charset.forName(charsetName)).forEach(System.out::println);


    //Older Java version
    final BufferedReader bufferedReader2 = new BufferedReader(
            new InputStreamReader(new FileInputStream("myFile.txt"), charsetName));

    String currentLine;
    while ((currentLine = bufferedReader2.readLine()) != null) {
        System.out.println(currentLine);
    }
}
}