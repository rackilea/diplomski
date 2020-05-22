public interface Interface1 {
  String first();
}

public interface Interface2 {
  String second();
}

public class Class1 implements Interface1 {
  @Override
  public String first() {
    return "first";
  }
}

public class Class2 implements Interface2 {
  @Override
  public String second() {
    return "second";
  }
}

public interface MixinInterface extends Interface1, Interface2 { /* empty */ }

@Test
public void testMixin() throws Exception {
  Mixin mixin = Mixin.create(new Class[]{Interface1.class, Interface2.class,
      MixinInterface.class}, new Object[]{new Class1(), new Class2()});
  MixinInterface mixinDelegate = (MixinInterface) mixin;
  assertEquals("first", mixinDelegate.first());
  assertEquals("second", mixinDelegate.second());
}