class ChainA {
  private ChainB b = new ChainB();
  ChainB getB() {
    return b;
  }
}
class ChainB {
  private ChainC c = new ChainC();
  ChainC getC() {
    return c;
  }
}
class ChainC {
  private ChainD d = new ChainD();
  ChainD getD() {
    return d;
  }
}

class ChainD {
  private int result = 0;
  int getResult() { return result; }
  void doSomething1(){ result += 1; }
  void doSomething2(){ result += 2; }
  void doSomething3(){ result += 3; }
}

class Chaining
{
    public static void main(String args[])
    {
        for (int n=100; n<10000; n+=100)
        {
            ChainA a0 = new ChainA();
            runChained(a0, n);
            System.out.println(a0.getB().getC().getD().getResult());

            ChainA a1 = new ChainA();
            runUnChained(a1, n);
            System.out.println(a1.getB().getC().getD().getResult());
        }

    }

    private static void runChained(ChainA a, int n)
    {
        for (int i=0; i<n; i++)
        {
            a.getB().getC().getD().doSomething1();
            a.getB().getC().getD().doSomething2();
            a.getB().getC().getD().doSomething3();
        }
    }

    private static void runUnChained(ChainA a, int n)
    {
        ChainD d = a.getB().getC().getD();
        for (int i=0; i<n; i++)
        {
            d.doSomething1();
            d.doSomething2();
            d.doSomething3();
        }
    }

}