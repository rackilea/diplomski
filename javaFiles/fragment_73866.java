class IntVerifier extends InputVerifier {

  @Override public boolean verify(JComponent input) {
      String text =((JTextField) input).getText();
      int n = 0; 

          try {
      n = Integer.parseInt(text); } 

      catch (NumberFormatException e) {
  return false; 
       }

  return true;
      }
      }