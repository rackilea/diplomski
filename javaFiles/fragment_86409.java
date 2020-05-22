public class CustomIntrospector extends JacksonAnnotationIntrospector
{
  @Override
  public Object findFilterId(AnnotatedClass ac) {
    // Let's default to current behavior if annotation is found:
    Object id = super.findFilterId(ac);
    // but use simple class name if not
    if (id == null) {
       id = "DEFAULT_FILTER";
    }
    return id;
}