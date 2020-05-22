public class DisablingMyJsonIgnoreIntrospector extends JacksonAnnotationIntrospector {

@Override
public boolean isAnnotationBundle(final Annotation ann) {
    if (ann.annotationType().equals(MyJsonIgnore.class)) {
        return false;
    } else {
        return super.isAnnotationBundle(ann);
    }
}