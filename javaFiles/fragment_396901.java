Scanner s = new Scanner(System.in);
System.out.println("Enter name: ");
String name = s.next();
s.nextLine();
if (name.equals("quit") 
   return;
//where should I put word = s.next
System.out.println("Enter address: ");
String address = s.nextLine();
if (address.equals("quit") 
   return;
System.out.println("Enter card number: ");
int cardNo = s.nextInt();
System.out.println("Enter card expiration date: (DDMMYY)");
int expirationDate = s.nextInt();
Customer newcust = new Customer(name, address, cardNo, expirationDate);