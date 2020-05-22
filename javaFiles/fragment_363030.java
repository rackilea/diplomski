public class A extends B{

  @Override
  public void foo(){
    System.out.println("yep");
    super.foo(); // calls the method implemented in B
  }  
}