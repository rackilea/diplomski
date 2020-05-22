try{
    String s1 = txtFirst.getText(); String s2 = txtSecond.getText();
    double d1= Double.parseDouble(s1);
    double d2= Double.parseDouble(s2);
    double result = d1+d2 ; 
    String s = String.valueOf(result);
    txtResult.setText(s);
}catch(Exception ex){
    JOptionPane.showMessageDialog(null, "Invalid Input", "Input Error", JOptionPane.INFORMATION_MESSAGE);
}