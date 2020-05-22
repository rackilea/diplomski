System.out.println("Guestnumber to update :");
Scanner sc = new Scanner(System.in);
String input = sc.next();
for (Gast test : verwaltungG) {
  int nummer = Integer.parseInt(input);
  if (test.getgNr() == nummer) {
     System.out.println("Enter new guest name for guest number : "+nummer );
     String name = sc.nextLine();
     System.out.println("Enter new guest email for guest number : "+nummer );
     String email = sc.nextLine();


     // now update the details
     test.setName(name);
     test.setEmail(email);
     break;
  }
}