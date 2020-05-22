public class Foo {
      public String name;
      public Long age;
    }

public class Bar {
      public String name() {
          return "Name";
      }
      public Long age() {
          return 21;
      }
    }

public class Demo {

    FooBar dynamicType = new ByteBuddy(ClassFileVersion.JAVA_V8)
            .subclass(Foo)
            .defineConstructor(PUBLIC)
                    .withParameter(Bar.class)
                    .intercept(MethodCall.(Foo.class.getDeclaredConstructor())
                    .andThen(MethodDelegation.to(this)))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded()
            .getConstructor(Bar.class)
            .newInstance(new Bar());

    public void intercept(@This Object thiz, @Argument(0) Bar bar) {
        thiz.name = bar.name();
        thiz.age = bar.age();
    }
}