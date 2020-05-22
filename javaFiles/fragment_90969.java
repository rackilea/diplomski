import java.util.*;

class Tbin<T> extends ArrayList<T> {}
class TbinList<T> extends ArrayList<Tbin<? extends T>> {}

class Base {}
class Derived extends Base {}

public class Test {
  public static void main(String[] args) {

    TbinList<Base> test3 = new TbinList<>();
    test3.add(new Tbin<Derived>());

  }
}