import org.apache.commons.io.IOUtils;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreInputStream;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class Upload extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
        BlobKey blobKey = blobs.get("myFile");

        if (blobKey != null) {
            String keyString = blobKey.getKeyString();
            // you can store keyString in the datastore or whatever
            // if you want the call the analytics API then you need the blob as string

             String csv = getBlobAsString(keyString);

             // you can do with csv whatever you like, convert it as an array, etc... then pass it
             // over to the analytic API
        } 
    }


   public static String getBlobAsString(String keyString) throws IOException {
        BlobKey blobKey = new BlobKey(keyString);
        BlobstoreInputStream blobStream = new BlobstoreInputStream(blobKey);

        return IOUtils.toString(blobStream, "UTF-8");
    }
 }