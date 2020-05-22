@Provider
@Produces({ MediaType.TEXT_PLAIN })
public class PlainTextJsonConverter extends GensonJsonConverter {
    public GensonJsonConverter() {
       super();
    }

    public GensonJsonConverter(@javax.ws.rs.core.Context Providers providers) {
       super(providers);
    }
}