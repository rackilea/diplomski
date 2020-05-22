// ShowSome is now set to, let's say 0...
ShowSome = JOptionPane.showInputDialog("Enter the amount of numbers you would like to average"); 
// AllNumbers  is now 0
double AllNumbers = Double.parseDouble(ShowSome);

while (AllNumbers < 1)
{
     // Prompting for a value, but you are ignoring it...
     JOptionPane.showInputDialog("You cannot enter a negative or a 0.  Enter the amount of numbers you would like to average");
     // Parsing ShowSome which is still 0 (as an example)...
     AllNumbers = Double.parseDouble(ShowSome);
 }//end while