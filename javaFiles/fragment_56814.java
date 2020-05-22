import javax.swing.JFrame;
   import javax.swing.JLabel;

   public class Main {
     public static void main(String[] args) {
       JFrame frame = new JFrame("TitleLessJFrame");
       frame.getContentPane().add(new JLabel(" HEY!!!"));
       frame.setUndecorated(true);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400, 200);
       frame.setVisible(true);
     }
   }