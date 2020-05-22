import java.security.AccessController;
import java.security.PrivilegedAction;    
import com.lowagie.text.FontFactory;

...

AccessController.doPrivileged(new PrivilegedAction<Object>() {
        public Object run() {
                FontFactory.registerDirectory(yourFontsDirectory);
                return null;
        }
});