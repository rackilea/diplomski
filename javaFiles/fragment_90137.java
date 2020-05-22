class Tester extends JFrame {

   private JButton button;
   private JLabel label;
   //..some more

   public Tester() {
        function(); // CALL FUNCTION
   }

   public void function() {
      Runnable r = new Runnable() {
         @Override
         public void run() {
            System.out.println("Button's text is: " + button.getText());
         }
      };
      new Thread(r).start();
   }
}