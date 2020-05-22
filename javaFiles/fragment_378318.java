import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;

public JSON post(String path, File file) throws RestException, IOException, URISyntaxException {
    return request(new HttpPost(buildURI(path)), file);
}

private JSON request(HttpEntityEnclosingRequestBase req, File file) throws RestException, IOException {
    if (file != null) {
        File fileUpload = file;
        req.setHeader("X-Atlassian-Token", "nocheck");
        MultipartEntity ent = new MultipartEntity();
        ent.addPart("file", new FileBody(fileUpload));
        req.setEntity(ent);
    }
    return request(req);
}