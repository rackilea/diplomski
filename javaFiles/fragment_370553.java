package folderapp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class FolderTestApp {

    public static void main(String[] args) throws URISyntaxException, IOException {
        new FolderTestApp();
    }

    public FolderTestApp() throws URISyntaxException, IOException {

        // determining the running jar file location
        String jarFilePath = getClass().getProtectionDomain().
                                getCodeSource().getLocation().toURI().getPath();

        // note, that the starting / is removed
        // because zip entries won't start with this symbol
        String zipEntryFolder = "catalogos/";

        try (ZipInputStream zipInputStream
                = new ZipInputStream(new FileInputStream(jarFilePath))) {

            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {

                System.out.println("processing: " + zipEntry.getName());

                if (zipEntry.getName().startsWith(zipEntryFolder)) {
                    // directory "catalogos" will appear as a zip-entry
                    // and we're checking this condition
                    if (!zipEntry.isDirectory()) {
                        // adding symbol / because it is required for getResourceAsStream() call
                        printProperties("/" + zipEntry.getName());
                    }

                }

                zipEntry = zipInputStream.getNextEntry();
            }

        }

    }

    public void printProperties(String path) throws IOException {

        try (InputStream is = getClass().getResourceAsStream(path)) {
            InputStreamReader fr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(fr);

            Properties properties = new Properties();
            properties.load(br);

            System.out.println("contents from: " + path + "\n");

            Set<Object> keySet = properties.keySet();
            for (Object key : keySet) {
                System.out.println(key + " = " + properties.get(key));
            }

            System.out.println("---------------------------------------");
        }
    }

}