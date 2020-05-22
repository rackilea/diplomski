@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyJavaAnnotation {
   int aValue() default A;
   static final int A = MyValues.a();
}