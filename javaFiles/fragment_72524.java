public class A implements Cloneable  // add 'implements'
{
  public Object clone()
  {
    A cloneA = super.clone(); // this copies all fields and returns something of *the same type* as 'this'...
    return cloneA;
  }
}

public class B extends A //supposed to extend 'A' right?
{
  public Object clone()
  {
    Object cloneA = super.clone(); // this returns object of runtime type B
    B cloneB = (B)cloneA; // will work
    return cloneB;
  }
}