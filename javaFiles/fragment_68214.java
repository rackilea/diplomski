import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.IOUtils;
import java.io.*;

public class TestKmz {

    public static void main(String[] args) throws IOException {     
        createKMZ();
        System.out.println("file out.kmz created");
    }

    public static void createKMZ()  throws IOException  {
        FileOutputStream fos = new FileOutputStream("out.kmz");
        ZipOutputStream zoS = new ZipOutputStream(fos);     
        ZipEntry ze = new ZipEntry("doc.kml");
        zoS.putNextEntry(ze);
        PrintStream ps = new PrintStream(zoS);          
        ps.println("<?xml version='1.0' encoding='UTF-8'?>");
        ps.println("<kml xmlns='http://www.opengis.net/kml/2.2'>");     
        // write out contents of KML file ...
        ps.println("<Placemark>");
        // add reference to image via inline style
        ps.println("  <Style><IconStyle>");
        ps.println("    <Icon><href>image.png</href></Icon>");
        ps.println("  </IconStyle></Style>");
        ps.println("</Placemark>");
        ps.println("</kml>");
        ps.flush();                 
        zoS.closeEntry(); // close KML entry

        // now add image file entry to KMZ
        FileInputStream is = null;
        try {                   
            is = new FileInputStream("image.png");
            ZipEntry zEnt = new ZipEntry("image.png");
            zoS.putNextEntry(zEnt);
            // copy image input to KMZ output
            // write contents to entry within compressed KMZ file
            IOUtils.copy(is, zoS);
        } finally {
            IOUtils.closeQuietly(is);
        }
        zoS.closeEntry();
        zoS.close();
    }   
}