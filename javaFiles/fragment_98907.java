import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@NameBinding
@Retention(value = RetentionPolicy.RUNTIME)
public @interface HtmlMinify {}