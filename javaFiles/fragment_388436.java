public class Test extends JFrame {

    public static void main(String[] args) {

       SwingUtilities.invokeLater(new Runnable() {
          public void run() {
           new Test().createUI();
          }
       });

    }

  void createUI() {

             setSize(500,500);
             getContentPane().add(new MyPanel());
             setVisible(true);      
       }
}