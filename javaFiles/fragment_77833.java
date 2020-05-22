textField.addActionListener(new ActionListener() {
   @Override
    public void actionPerformed(ActionEvent e) {
      textField1.requestFocusInWindow();    
    }
}); 

textField1.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
      textField.requestFocusInWindow(); 
   }
});