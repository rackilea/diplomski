import java.net.URL;
import java.util.Hashtable;
import javax.naming.*;
import javax.naming.spi.ObjectFactory;

public class URLFactory implements ObjectFactory {
 public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable environment) throws Exception {
 Reference ref = (Reference) obj;
 String urlString =  (String) ref.get("url").getContent();
 return new URL(urlString);
 }
}