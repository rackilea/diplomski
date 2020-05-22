import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Main {

    public static void main(String[] args) throws Exception {
        ZipFile zipFile = new ZipFile("D:\\zip.zip");
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while(entries.hasMoreElements()) {
            ZipEntry zipEntry = entries.nextElement();
            System.out.println(zipEntry.getName());
            BufferedReader bufferedeReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(zipEntry)));
            String line = bufferedeReader.readLine();
            while(line != null) {
                System.out.println(line);
                line = bufferedeReader.readLine();
            }
            bufferedeReader.close();
        }
        zipFile.close();
    }

}