public class CustomAnnotationIntrospector extends AnnotationIntrospector {
    @Override
    public Version version() {
        return DatabindVersion.instance.version();
    }

    @Override
    public Object findFilterId(AnnotatedClass ac) {
      // CustomFilter is used for EVERY Bean, unless another filter is defined
      Object id = super.findFilterId(ac);
      if (id == null) {
        id = "CustomFilter";
      }
      return id;
    }

    @Override
    public Object findSerializer(Annotated am) {
        FilterUsingView annotation = am.getAnnotation(FilterUsingView.class);
        if(annotation == null){
            return null;
        }
        return new CustomSerializer(annotation.value());
    }
}