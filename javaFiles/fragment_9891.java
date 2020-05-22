class MyFrame extends JFrame {
   private MyPanel myPanel;

   public MyFrame() {
      myPanel = new MyPanel(this);
   }

   public void frameMethod() {
      System.out.println("in JFrame's frameMethod");
   }

}

class MyPanel extends JPanel {
   private MyFrame myFrame;
   private JButton someButton = new JButton("Button");

   public MyPanel(final MyFrame myFrame) {
      this.myFrame = myFrame;

      someButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            myFrame.frameMethod();
         }
      });
   }  
}