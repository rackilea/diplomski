public class A{
  public int value1;
  public class B{
    public int value2;
  }
}
...
A a1 = new A()
a1.value1 = 202
A.B b1 = new a1.B();
System.out.println(b1.value1); //Prints 202
A.B b2 = new B(); //Compiler error! Not allowed