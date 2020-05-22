import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.*;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws URISyntaxException, InvalidKeyException, StorageException {

        String storageConnectionString ="connection string";

        CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
        CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
        CloudBlobContainer container = blobClient.getContainerReference("test");

        CloudBlockBlob blob = container.getBlockBlobReference("test.txt");

        SharedAccessBlobPolicy sasPolicy = new SharedAccessBlobPolicy();

        // Create a UTC Gregorian calendar value.
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        // Use the start time delta one hour as the end time for the shared
        // access signature.
        calendar.add(Calendar.HOUR, 10);
        sasPolicy.setSharedAccessExpiryTime(calendar.getTime());

        sasPolicy.setPermissions(EnumSet.of(SharedAccessBlobPermissions.READ, SharedAccessBlobPermissions.WRITE,
                SharedAccessBlobPermissions.LIST));
        String sas = blob.generateSharedAccessSignature(sasPolicy,null);

        String sasurl=blob.getUri()+"?"+sas;

        System.out.println(sasurl);


    }
}