int myTotal = 0;
while(scan.hasNextLine()) {
  String line = scan.nextLine();
  System.out.println("Line read: " + line);
  char[] digit = line.toCharArray();
  for(int i = 0; i < digit.length; i++) {
    for(int j = 0; j < 26; j++) {
      if(digit[i] == capital[j] || digit[i] == small[j]) {
        count[j]++;
        myTotal = myTotal + 1;
        break;
      }
    }
  }
}
System.out.println("");
System.out.println("Comlete count");
for (int i = 0; i < 26; i++)
{
  System.out.print(" " + small[i]);
  System.out.print(" " + count[i]);
  if (count[i] > 0)
    System.out.println(" " + (((float) count[i]/myTotal)*100) + "%");
  else
    System.out.println(" 0%");
  //calculate percentage for the full count
}