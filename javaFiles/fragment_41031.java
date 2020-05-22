========== test/refl/a/Base.java ========== 
     1  package refl.a; 
     2   
     3  class Base { 
     4      public void f() { 
     5          System.out.println("Hello, world!"); 
     6      } 
     7  } 
========== test/refl/a/Pub.java ========== 
     1  package refl.a; 
     2   
     3  public class Pub extends Base {} 
========== test/refl/ClientTest.java ========== 
     1  package refl; 
     2  import refl.a.*; 
     3  import java.lang.reflect.*; 
     4   
     5  public class ClientTest { 
     6      public static void main(String[] args) throws Exception { 
     7          Pub p = new Pub(); 
     8          Method m = Pub.class.getMethod("f"); 
     9          m.invoke(p); 
    10      } 
    11  }