import java.util.List;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
@interface Valid{}

public class GroupPayload<T> {
    List<@Valid T> data;
}