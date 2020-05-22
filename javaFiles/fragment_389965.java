import com.google.cloud.storage.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class Download {

    public static String perform(String bucket, String file) throws Exception {
        byte[] fileByte = download(bucket, file);
        String pdfFileTxt = pdf2txt2(fileByte);
        return pdfFileTxt;
    }

    public static byte[] download(String bucketName, String fileId) throws IOException {
        Storage storage = StorageOptions.getDefaultInstance().getService();
        BlobId blobId = BlobId.of(bucketName, fileId);
        Blob blob = storage.get(blobId);
        return blob.getContent();
    }


    public static String pdf2txt2(byte[] byteArr) throws IOException {
        InputStream myInputStream = new ByteArrayInputStream(byteArr);
        PDDocument pddDoc = PDDocument.load(myInputStream);
        PDFTextStripper reader = new PDFTextStripper();
        String pageText = reader.getText(pddDoc);
        pddDoc.close();
        return pageText;
    }
}