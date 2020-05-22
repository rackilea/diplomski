@AutoFactory
public class SomeClass {

  SomeClass(@Provided com.fully.qualifiedpath.AnotherClassFactory anotherClassFactory,
            @Provided SomeDependency someDependency,
            int someValue) {
    ...
  }
}