import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestClass {
    public static void main (String[] args) throws IOException {
        InputStream exeInputStream = TestClass.class.getClassLoader().getResourceAsStream("resources/IEDriverServer.exe");
        File tempFile = new File("./temp/IEDriverServer.exe");

        OutputStream exeOutputStream = new FileOutputStream(tempFile);
        IOUtils.copy(exeInputStream, exeOutputStream);

        // ./temp/IEDriverServer.exe will be a usable file now.
        System.setProperty("webdriver.ie.driver", tempFile.getAbsolutePath());
    }
}