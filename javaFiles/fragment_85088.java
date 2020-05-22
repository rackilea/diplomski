@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
   TestAnnotationChild child();

   // Or for an array
   TestAnnotationChild[] children();
}