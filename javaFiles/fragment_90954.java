public abstract class BaseResource<T> {
    @Context
    protected HttpHeaders headers;

    protected String getCertainHeader() {
        return headers.getHeaderString("Certain-Header");
    }

    protected String getHeader(String headerName) {
        return headers.getHeaderString(headerName);
    }
}

@Path("/foo")
public class FooResource extends BaseResource<Foo> {

    @GET
    public Response getSomething() {
        String certainHeader = getCertainHeader();
    }
}