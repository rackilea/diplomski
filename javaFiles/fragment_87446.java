Scanner scanner = new Scanner(new File("submit.txt"));

int trials = scanner.nextInt();
scanner.nextLine(); //Add this line, to consume the newline character after "5"
// alternatively, you could replace both of the above lines with this:
// int trials = Integer.parseInt(scanner.nextLine());
int total = 0;

for(int x = 0; x <= trials; x++){
   String sub = scanner.nextLine();
   sub = sub.toLowerCase();
   if(sub.substring(0,5).equals("today")) //compare strings using equals, not ==
     System.out.println("VALID ENTRY");
   else
     System.out.println("INCORRECT FORMATTING, TRY ANOTHER SUBMISSION");

}