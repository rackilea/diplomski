class GetInputPanel extends JPanel {
   // almost arbitrary numbers below. 
   // you'll want to change this
   private static final int PREF_W = 500; 
   private static final int PREF_H = 40;
   private JLabel promptLabel = new JLabel();
   private JTextField inputField = new JTextField(10);
   private JButton doActionButton = new JButton();

   public GetInputPanel() {
      add(promptLabel);
      add(inputField);
      add(doActionButton);
   }

   // the most important method
   // allow outside objects the ability to change
   // our JButton and JTextField's Action
   public void setAction(Action action) {
      inputField.setAction(action);
      doActionButton.setAction(action);
      // note that setting a JButton's Action
      // will change its text and the action it 
      // performs on being pressed
   }

   // allow outside objects the ability to change
   // our promptLabel's text
   public void setPrompt(String prompt) {
      promptLabel.setText(prompt);
   }

   public String getInputText() {
      return inputField.getText();
   }

   public void clearInputText() {
      inputField.setText("");
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   public void setEnabled(boolean enabled) {
      super.setEnabled(enabled);
      inputField.setEnabled(enabled);
      doActionButton.setEnabled(enabled);
   }
}