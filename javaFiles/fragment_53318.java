String s =JOptionPane.showInputDialog("Enter two numbers like this: Number A;Number B", "AB");
String[] temp = s.split(";");
if(temp.length == 2) {
  try {
    int aNum = Integer.parseInt(temp[0]);
    int bNum = Integer.parseInt(temp[1]);
    int cNum = aNum*bNum;
  } catch(NumberFormatException nfe) {
    // One or both of the values weren't ints.
  }
} else {
  // Some error here, because of too few/ too many values
}