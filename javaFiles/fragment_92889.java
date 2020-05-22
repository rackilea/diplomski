public class{
  int i = 10;

  public main(){
     class A{
        void show(){
          System.out.println(i);
        }
     }

     //inside the method instantiate local class.
     A obj = new obj();
     obj.show();
  }
  //outside the main() -block(method)
  //inside another method instantiate local class.
  public test(){
    A obj = new A();
    obj.show();
  }
}