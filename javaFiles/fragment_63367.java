import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class Main {
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis = new FileInputStream("c:/inas400.zip");

        // this is where you start, with an InputStream containing the bytes from the zip file
        ZipInputStream zis = new ZipInputStream(fis);
        ZipEntry entry;
            // while there are entries I process them
        while ((entry = zis.getNextEntry()) != null)
        {
            System.out.println("entry: " + entry.getName() + ", " + entry.getSize());
                    // consume all the data from this entry
            while (zis.available() > 0)
                zis.read();
                    // I could close the entry, but getNextEntry does it automatically
                    // zis.closeEntry()
        }
    }
}