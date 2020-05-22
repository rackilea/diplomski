import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.ListBlobItem;

public class Main {

    public static void main(String[] args) {
    // TODO Auto-generated method stub

    CloudStorageAccount account;
    try {
        account = CloudStorageAccount.parse("DefaultEndpointsProtocol=https;AccountName=leeliublob;AccountKey=O7xxxxxxxxxxxxxxx/x/e9l9FhLqayXcbz1R+E0mIcJ5Wjkly1DsQPYY5dF2JrAVHtBozbJo29ZrrGJA==;EndpointSuffix=core.windows.net");
        CloudBlobClient client = account.createCloudBlobClient();

        Iterable<CloudBlobContainer> containers = client.listContainers();
        for (CloudBlobContainer cloudBlobContainer : containers) {
            Iterable<ListBlobItem> blobs = cloudBlobContainer.listBlobs();
            System.out.println("BlobContainer : "+ cloudBlobContainer.getName());
            System.out.println("   blobs inside container '"+cloudBlobContainer.getName()+"' are: ");
            int x=1;
            for (ListBlobItem blobItem : cloudBlobContainer.listBlobs()) {
                String blobName = blobItem.getUri().toString();
                System.out.println("         Number "+x+": url="+ blobItem.getUri().toString());
            x++;
            }

        }
    } catch (InvalidKeyException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (URISyntaxException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }



    }

}