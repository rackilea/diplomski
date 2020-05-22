class A{
  public class B{ 
    public void f() {
      System.out.println(A.this.aField);
    }    
  }
  String aField;
  B b = new B(); // Passes a hidden `this` parameter
}