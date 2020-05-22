import org.apache.commons.io.IOUtils;
@POST
@Path("MyMethod") 
@Consumes("*/*") // to accept all input types 
public String MyMethod(InputStream stream) {
    byte[] image = IOUtils.toByteArray(stream);
    return "done";
}