boolean taken = false;
int myInteger = 0;
while(!taken){
   String s = (String)JOptionPane.showInputDialog(this, "Your question", "Your window title", JOptionPane.PLAIN_MESSAGE, null, null, "");

   //Check if input is an integer
   try{
      myInteger = Integer.parseInt(s);
      taken = true;
   catch(NumberFormatException e){
      taken = false;
   }
}