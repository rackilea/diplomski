import javax.ws.rs.core.Context;
import org.apache.cxf.jaxrs.ext.MessageContext;

...
// add the attribute to your implementation
@Context 
private MessageContext context;

...
// then you can access the request/response/session etc in your methods
HttpServletRequest req = context.getHttpServletRequest();
HttpServletResponse res = context.getHttpServletResponse()