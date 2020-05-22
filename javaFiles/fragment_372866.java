private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    DecimalFormat z = new DecimalFormat("0.00");
    try  {
      double x = Double.parseDouble(fnum.getText());     
      double y = Double.parseDouble(secondnum.getText());
      double f = x + y;
      String number = z.format(f);
      answer.setText("" + number);
    } catch(NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "please input a valid number");
    }
}