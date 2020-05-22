// This uses Multibindings, but you could manually create a Map instead.

@Binds @IntoMap @StringKey("Child1")
abstract BaseClass provideChild1(Child1 child1);

@Binds @IntoMap @StringKey("Child2")
abstract BaseClass provideChild2(Child2 child2);

// Then in your consumer...

@Inject Map<String, BaseClass> mapOfBaseClasses;
@Inject BaseClass baseClass;

// Or make an injectable Factory:

public class YourClassFactory {
  private final Map<String, Provider<BaseClass>> baseClassMap;
  private final Provider<BaseClass> baseClassProvider;

  @Inject public YourClassFactory(/* ... */) { /* set fields */ }

  public BaseClass get(String key) { /* write fallback logic here */ }
}