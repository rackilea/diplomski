public static void main(String[] args) throws Exception {
    final Something oldAnnotation = (Something) Foobar.class.getAnnotations()[0];
    System.out.println("oldAnnotation = " + oldAnnotation.someProperty());
    Annotation newAnnotation = new Something() {

        @Override
        public String someProperty() {
            return "another value";
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return oldAnnotation.annotationType();
        }
    };
    Field field = Class.class.getDeclaredField("annotations");
    field.setAccessible(true);
    Map<Class<? extends Annotation>, Annotation> annotations = (Map<Class<? extends Annotation>, Annotation>) field.get(Foobar.class);
    annotations.put(Something.class, newAnnotation);

    Something modifiedAnnotation = (Something) Foobar.class.getAnnotations()[0];
    System.out.println("modifiedAnnotation = " + modifiedAnnotation.someProperty());
}

@Something(someProperty = "some value")
public static class Foobar {
}

@Retention(RetentionPolicy.RUNTIME)
@interface Something {

    String someProperty();
}