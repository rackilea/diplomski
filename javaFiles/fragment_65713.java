import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.me.fileStore.service.FileStoreService;

@RestController
@Path("/filestore")
public class FileStoreRestService {
    private static Logger logger = LoggerFactory.getLogger(FileStoreRestService.class);

    @Autowired
    private FileStoreService fileStoreService;


    @POST
    @Path("upload")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Produces(MediaType.APPLICATION_JSON)
    public Response Upload(InputStream stream) throws IOException, URISyntaxException { //
        String location = fileStoreService.upload(stream);  // relative path
        URI loc = new URI(location);
        Response response = Response.created(loc).build();
        System.out.println("POST - response: " + response + ", :" + response.getHeaders());
        return response;
    }