class CustomJPanel extends JPanel {
   private JButton myButton;
   public CustomJPanel() {
      initializeComponents();
   }
   public void initializeComponents() {
      myButton = new JButton();
   }
   public void setButtonAction(javax.swing.Action action)
   {
      myButton.setAction(action);
   }
}