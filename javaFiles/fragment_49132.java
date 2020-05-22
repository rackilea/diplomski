public interface One {
  void method1();
  void method2();
  void method3();
  void method4();
}

public interface Two extends One{
  default void method1(){}
  default void method2(){}
}

public class Three implements Two{

  @Override
  public void method3() {}

  @Override
  public void method4() {}

}