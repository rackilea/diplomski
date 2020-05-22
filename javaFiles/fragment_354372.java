DecimalFormat decimalFormat = new DecimalFormat("0.00##");
int num1;
int num2;
int num3;
double avg;

num1= Integer.valueOf(JOptionPane.showInputDialog("Enter #1"));
num2= Integer.valueOf(JOptionPane.showInputDialog("Enter #2"));
num3= Integer.valueOf(JOptionPane.showInputDialog("Enter #3"));

avg=(double)(num1+num2+num3)/3.0;
JOptionPane.showMessageDialog(null,  "The average is: " + decimalFormat.format(avg));