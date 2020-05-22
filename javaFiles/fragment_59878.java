@AutoFactory
public class SomeClass {

  SomeClass(@Provided AnotherClassFactory anotherClassFactory,
            @Provided SomeDependency someDependency,
            int someValue) {
    ...
  }
}