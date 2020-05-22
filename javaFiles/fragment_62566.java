public class Test {
  public interface ICommandAble {
  }

  public interface ILogAble extends ICommandAble {
  }

  public interface IMonitorAble extends ICommandAble {
  }

  public abstract class ClassAbs {
  }

  public class A extends ClassAbs implements IMonitorAble, ILogAble {
  }

  public class B extends ClassAbs implements IMonitorAble {
  }

  public class C extends ClassAbs implements ILogAble {
  }

  public void test() {
    A a = new A();
    B b = new B();
    C c = new C();
    List<ICommandAble> commandList = new ArrayList<ICommandAble>();
    commandList.add(a); // Remove this line to just get the two printouts.
    commandList.add(b);
    commandList.add(c);
    for (ICommandAble item : commandList) {
      if (item instanceof IMonitorAble) {
        System.out.println(item.getClass().getSimpleName() + " is monitorable");
      }
      if (item instanceof ILogAble) {
        System.out.println(item.getClass().getSimpleName() + " is logable");
      }
    }
  }

  public static void main(String args[]) {
    new Test().test();
  }
}