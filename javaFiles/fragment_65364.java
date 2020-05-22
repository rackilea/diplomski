private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
  try{
    int x = Integer.parseInt(jTextField1.getText());
    int y = Integer.parseInt(jTextField2.getText());
    jTextField3.setText((x + y)+"");
  catch(Exception e){
    //-- NumberFormatException hadling
  }
}