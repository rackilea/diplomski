Scanner input = new Scanner(System.in);
String text = input.nextLine();
text=text.replaceAll("\\s+","");
int i;
for (i = 0; i < text.length()-1; i+=2) {
   if (text.charAt(i) == '0') {
      if (text.charAt(i+1) == '1') 
         System.out.print("0");
       else if (text.charAt(i+1) == '0') {
         System.out.print("1");
    } else {
       if (text.charAt(i+1) == '0') 
         System.out.print("1");
       else if (text.charAt(i+1) == '1') 
         System.out.print("0");
    }
}