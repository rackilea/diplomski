class A {  
     static{  // static
       System.out.println("Static block of Class A");  
     }  

     { // non-static  
       System.out.println("Non-Static block of a instance of Class A");  
     }  
  public A(){  
    System.out.println("Constructing object of type A");  
  }  
}  

public class StaticTest {  
  public static void main(String[] args) {  
    A a1 = new A();  
    A a2 = new A();  

  }  
}