import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class FileDownloader {

    public static void main(String[] args) throws IOException {

        InputStream fileIn;
        FileOutputStream fileOut;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter URL: ");
        String urlStr = s.nextLine();

        URL url = new URL(urlStr);
        URLConnection urlConnect = url.openConnection();
        fileIn = urlConnect.getInputStream();

        System.out.println("Enter file name: ");
        String fileStr = s.nextLine();
        fileOut = new FileOutputStream(fileStr);

        int x;
        while ((x = fileIn.read()) != -1) {
            fileOut.write(x);
        }
        System.out.println("File is downloaded");

}