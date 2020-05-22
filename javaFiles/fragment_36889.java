public class TestClass {
  public static void foo(Parameter parameter) {
    parameter.childSpecific();
  }

  public static void main(String args) {
    execute(TestClass::foo, new Parameter());
  }

  public static <P extends IParameter> void execute(
        IExecutable<P> executable, P param) {
    executable.execute(param);
  }
}