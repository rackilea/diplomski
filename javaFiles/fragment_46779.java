public class FormFrame extends JFrame {

   public FormFrame() {
       super("Oracle Forms");
       MyApplet myApplet = new MyApplet();
       myApplet.start();
       myApplet.init();
       getContentPane().add(myApplet.getContentPane()); 
       setSize(800, 600); // not sure about this.  Usually better to call pack();
       setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            new FormFrame();
         }
      });
   }
}