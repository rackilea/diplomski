new MainFrame().setVisible(true); //calls MainFrame() while creating new object instance
...
JTextField t = new JTextField(20); //creates an empty text field
...
if (a==true)
{
  String input = t.getText(); //t has just been created so it is empty
  System.out.print(input); //t is empty so input is empty
  ...
}