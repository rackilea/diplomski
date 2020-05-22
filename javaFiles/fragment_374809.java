public class Myclass{

      JFrame frame;

      public MyClass(JFrame aFrame){
           this.frame = aFrame;
      }

      public void Frame_normal{


           frame.setState(Frame.NORMAL);

      }

 }

 MyClass class = new Myclass(theJFrame);
 class.Frame_normal();