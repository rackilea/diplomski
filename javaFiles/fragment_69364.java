package ...
import javax.faces.application.ResourceHandler;
import org.richfaces.resource.ResourceHandlerImpl;
import org.apache.myfaces.orchestra.conversation.ConversationRequestParameterProvider;

public class RfOrchestraParamControlResponseWrapper extends HttpServletResponseWrapper {

   public RfOrchestraParamControlResponseWrapper(HttpServletResponse httpServletResponse) {
      super(httpServletResponse);
   }

   @Override
   public String encodeURL(String url) {
      if (url.contains(ResourceHandler.RESOURCE_IDENTIFIER) || url.contains(ResourceHandlerImpl.RICHFACES_RESOURCE_IDENTIFIER)) {
         boolean current = ConversationRequestParameterProvider.isInSeparationMode();
         /* Disable conversationContext parameter in current thread for the time of rendering link to a resource */
         ConversationRequestParameterProvider.setInSeparationMode(true);

         String result = super.encodeURL(url);

         /* Restore */
         ConversationRequestParameterProvider.setInSeparationMode(current);
         return result;
      }
      else return super.encodeURL(url);
   }

}