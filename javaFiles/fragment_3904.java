int x = Integer.parseInt(jTextField1.getText().toString()); // getText needs to be converted to String before parsing it to int.

if (x>=120 && x<200) { //in the if condition you need two && not one &
    JOptionPane.showMessageDialog(null, "select drum : PPJ upwards");//semicolon should be here 
}//putting semicolon here is wrong

else if (x>=230 && x<=300)//putting semicolon here is also wrong
{
    JOptionPane.showMessageDialog(null,"select drum :RRf Upwards");
}
else {
    JOptionPane.showMessageDialog(null,"incorrect entry");
 }