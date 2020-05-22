import com.microsoft.azure.storage.blob.CloudBlockBlob;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

public class DownloadBlobSAS {

    public static final String blobSasToken = "***";

    public static void main(String[] args) {
        try {
            CloudBlockBlob sasBlob = new CloudBlockBlob(new URI(blobSasToken));

            InputStream input =  sasBlob.openInputStream();
            InputStreamReader inr = new InputStreamReader(input, "UTF-8");
            String utf8str = org.apache.commons.io.IOUtils.toString(inr);
            System.out.println(utf8str);

            System.out.println("print done");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}