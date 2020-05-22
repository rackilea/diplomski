public abstract class AbstractA
 {
  protected B newB() {return new B();}
  public static final class B
  { 
   private B(){}
  }
 }

 // a class (in another package) that inherits from AbstractA
 public class C extends AbstractA
 {
  B[] arrayOfB=new B[10]; 
  for(byte i=0; i<=arrayOfB.length; i++)
  {
   arrayOfB[i]=this.newB(); 
  }
 }