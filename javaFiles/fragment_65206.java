@CustomTypeAnnotation
public class MyAnnotatedClass {
  @CustomFieldAnnotation
  private String foo;

  @CustomConstructorAnnotation
  public MyAnnotatedClass() {
  }

  @CustomMethodAnnotation
  public String bar(@CustomParameterAnnotation String str) {
    @CustomLocalVariableAnnotation String asdf = "asdf";
    return asdf + str;
  }
}