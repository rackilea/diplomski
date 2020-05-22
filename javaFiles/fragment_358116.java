import java.io.ByteArrayOutputStream;
import java.util.Base64;

if (header.equals("Content-Disposition: form-data; name=\"file_base64\"")) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    multipartStream.readBodyData(baos);
    String content = baos.toString();
    // System.out.println(content);
    int index = content.indexOf(",")+1; // Get the index of base64 string in data-uploaded string
    byte[] imgBytes = Base64.getDecoder().decode(content.substring(index)); // convert image base64 string to image byte arrays
    ....
    // To upload image byte array to Blob Storage
    // You can get the upload image filename from the form input `note`, please notes the order of form input elements.
} else {
    multipartStream.readBodyData(System.out);
}