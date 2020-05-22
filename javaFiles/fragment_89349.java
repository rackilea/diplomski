interface C {
  public Date getA();
  public void setA(Date a);

}
interface C_Factory <X extends C> {
  X createInstance();
}

class C1 implements C {
  Date a;
  int b;

  public C1() {
    super();
  }

  public Date getA() { return a;  }
  public void setA(Date a) {  this.a = a;  }


  public int getB() { return b; }
  public void setB(int b) {  this.b = b;  }
}

class C2 implements C {
  Date a;
  float b;

  public C2() {
    super();
  }

  public Date getA() { return a;  }
  public void setA(Date a) {  this.a = a; }


  public float getB() { return b; }
  public void setB(float b) {  this.b = b;  }
}

public class CommonFunc {
  // You need this extra param to create instances----
  //                                                 V
  static <X extends C> X doSomething(Date d, Class<X> clazz)
  throws InstantiationException, IllegalAccessException
  // You'll have to accept those exceptions as well
  {
    // the next statement uses clazz as a factory for new X instances
    // As such, you can abstract the method further and use
    // a custom Factory class instead.
    X toret=clazz.newInstance();
    toret.setA(d);
    // something else

    return toret;
  }

  // A custom factory variant of the above
  static <X extends C> X doSomething(Date d, C_Factory<X> factory)
  {
    X toret=factory.createInstance();
    toret.setA(d);
    // something else

    return toret;
  }

  static public void main(String[] args) {
    try {
      C1 c1=doSomething(new Date(), C1.class);
      C2 c2=doSomething(new Date(), C2.class);
    } catch (InstantiationException | IllegalAccessException e) {
      // Should not happen
      e.printStackTrace();
    }
  }
}