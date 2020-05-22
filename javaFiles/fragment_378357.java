Scanner scan = new Scanner (System.in);
System.out.println ("Enter a noun that classifies the"
                    + " type of your product:");

String noun = scan.nextLine();
String inputnoun = noun.split(" ")[0];