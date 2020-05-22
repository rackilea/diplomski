String result;
try{
 int value = Integer.parseInt(a)+Integer.parseInt(b);
 result = String. valueOf(value) ;
}catch(NumberFormatException ex){
 //either a or b is not a number
 result = "Invalid input";
}
JOptionPane.showMessageDialog(null,result);