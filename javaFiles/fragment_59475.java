public Object[][] showDialogWithTable() {
   //do some needed actions
   setVisible(true);

   //when user closes JDialog with a JTable collect data from the table
   Object[][] data = collectData();

   return data;
}