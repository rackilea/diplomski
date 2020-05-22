int i = 0;
int j = 0;
Scanner s = new Scanner(System.in);
System.out.println("Please enter something!");
String e = s.nextLine();

while (!Character.isDigit(e.charAt(i))) i++; // finding index 
                                             // where substring of first number starts
j = i;
while (Character.isDigit(e.charAt(j))) j++; // finding index
                                            // where substring of first number ends
String number = e.substring(i, j));