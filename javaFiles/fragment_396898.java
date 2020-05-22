if (jTextField1.getText() != null ) {
   double value = Double.parseDouble(jTextField1.getText());
   String text1 = (value * 0.62137) + "";
   String text2 = (value * 1.62137) + "";

   jTextField2.setText(text1);
   jTextField1.setText(text2);
}