public class Other {

   public void doSomething(JFrame jFrame) {
      ...
   }
} 

public class MyFrame extends JFrame {

   Other other = new Other();

   public void method() {
      other.doSomething(this);
   }

}