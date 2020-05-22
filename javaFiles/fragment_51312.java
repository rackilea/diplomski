import java.io.*;
import static java.lang.Integer.parseInt;
import java.net.URLConnection;
import java.net.URL;
import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.Enumeration;
import sign.signlink;
import java.nio.file.*;

public class ClientUpdater {

    private String fileToExtractNew = "/client.zip";

    private static String getJarDir() throws FileNotFoundException, IOException{
        String linebuf="",verStr="";
        FileInputStream fis = new FileInputStream("/runLocationURL.txt");
        BufferedReader br= new BufferedReader(new InputStreamReader(fis));
        while ((linebuf = br.readLine()) != null) {
            verStr = linebuf;
        }
        return verStr;
    }

    public static void main(String[] args) {
        System.out.println("start");
        unZip();
    }

    private static void unZip() {
        System.out.println("unzipping");
        try {
            ZipEntry zipEntry;
            //client
            BufferedInputStream bufferedInputStreamNew = new BufferedInputStream(new FileInputStream(this.fileToExtractNew));
            ZipInputStream zipInputStreamNew = new ZipInputStream(bufferedInputStreamNew);

            //client
            while ((zipEntry = zipInputStreamNew.getNextEntry()) != null) {
                String stringNew = zipEntry.getName();
                File fileNew = new File(this.getJarDir() + File.separator + stringNew);
                if (zipEntry.isDirectory()) {
                    new File(this.getJarDir() + zipEntry.getName()).mkdirs();
                    continue;
                }
                if (zipEntry.getName().equals(this.fileToExtractNew)) {
                    this.unzipNew(zipInputStreamNew, this.fileToExtractNew);
                    break;
                }
                new File(fileNew.getParent()).mkdirs();
                this.unzipNew(zipInputStreamNew, this.getJarDir() + zipEntry.getName());
            }
            zipInputStreamNew.close();
        }
        catch (Exception var1_2) {
            var1_2.printStackTrace();
        }
    }

    private static void unzipNew(ZipInputStream zipInputStreamNew, String stringNew) throws IOException {
        System.out.println("unzipping new");
        FileOutputStream fileOutputStreamNew = new FileOutputStream(stringNew);
        byte[] arrby = new byte[4024];
        int n = 0;
        while ((n = zipInputStreamNew.read(arrby)) != -1) {
            fileOutputStreamNew.write(arrby, 0, n);
        }
        fileOutputStreamNew.close();
        Runtime.getRuntime().exec("java -jar " + getJarDir() + "/Project Pk Client.jar");
        System.exit(0);
    }
}