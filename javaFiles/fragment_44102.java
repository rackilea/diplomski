public class TimerJFrame extends JFrame{    
    private static final long serialVersionUID = 1L;
    private JLabel label;

    public TimerJFrame() {
     setDefaultCloseOperation(EXIT_ON_CLOSE);
         setSize(200, 200);
         label = new JLabel("10", JLabel.CENTER);
         getContentPane().add(label);
         new TestTimer(label);
         setVisible(true);
    }

    public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            new TimerJFrame();
         }
      });
   }
}