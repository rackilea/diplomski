String number;
 int n = 3;
 Scanner input = new Scanner(System.in);
 System.out.print("Please enter your phone number: ");
 number = input.nextLine();
 String b = number.substring(0, n);
 String me=null;
 if (b.equals("013")) {
    me = "TM";
 }
 switch (me) {
   case "TM":
     System.out.println("Answer: The phone number is a TM number.");
     break;
   case "Celcom":
     System.out.println("Answer: The phone number is a Celcom number.");
     break;
   case "DiGi":
     System.out.println("Answer: The phone number is a DiGi number.");
     break;
   case "Maxis":
     System.out.println("Answer: The phone number is a Maxis number.");
     break;         
}