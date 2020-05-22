public class Test3 {
   public static void main(String[] args) {
      MyA myA = new MyA();
      System.out.println("foo := " + myA.foo);
   }
}

class MyC {
   public int foo = 3;
   //Stuff
}
class MyB extends MyC {
   public String foo = "foo";
   //Stuff
}

class MyA extends MyB {

}