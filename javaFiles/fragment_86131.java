import my.package.User
import org.codehaus.groovy.runtime.InvokerHelper;

List allInstances = (List)InvokerHelper.invokeMethod(User.class, "list", null)); 

User one=(User)InvokerHelper.invokeMethod(User.class, "get", id);