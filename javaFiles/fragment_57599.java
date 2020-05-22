stephen@blackbox tmp]$ cat > Test.java
public class Test {

   public static void main(String[] args) {
       System.out.println("started");
       //func();

   }

   static void func(){
       double d;
       int i;
       System.out.println("d ="+d);
       System.out.println("i ="+i);
   }

}
[stephen@blackbox tmp]$ javac Test.java 
Test.java:12: error: variable d might not have been initialized
       System.out.println("d ="+d);
                                ^
Test.java:13: error: variable i might not have been initialized
       System.out.println("i ="+i);
                                ^
2 errors
[stephen@blackbox tmp]$