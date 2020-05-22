private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // TODO add your handling code here:
    int c;
   c=Integer.parseInt ( jTextField2.getText()) ;

   jTextField1.setVisible(true );

   if(c>50)
   {
       jTextField1.setText("A WARD");

   }
   else 
        jTextField1.setText(" B WARD");


   revalidate();
}