try{
   input = Double.parseDouble(answer.getText());               
}
catch (NumberFormatException ex){
   canRun = false;
   JOptionPane.showMessageDialog(null, "Please enter a valid number!");
   answer.requestFocus();
   answer.selectAll();

   return; // ****** added *****
}