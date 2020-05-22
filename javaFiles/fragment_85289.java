// Say RF which locator to use to create classes in server side
 @ProxyFor(value = Foo.class, locator ALocator.class)
 interface Foo extends ValueProxy {
 }

 public class ALocator extends Locator<Foo, String>  {
   public Foo create(Class<? extends Foo> clazz) {
    return new FooImpl();
   }
   ...
 }