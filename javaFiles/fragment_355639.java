import com.fasterxml.jackson.annotation.*;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation // important so that it will get included!
public @interface JsonId {
}