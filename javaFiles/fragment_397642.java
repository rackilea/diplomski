public class FooWrapper {

  private final Foo delegate;

  private final JavaBeanObjectProperty<SomeType> value;

  @SuppressWarnings("unchecked") // Reason: Bad API
  public FooWrapper(Foo delegate) {
    this.delegate = delegate;
    try {
      value = JavaBeanObjectPropertyBuilder.create()
          .bean(delegate)
          .name("value")
          .build();
    } catch (NoSuchMethodException ex) {
      throw new RuntimeException(ex);
    }
  }

}