final String msg = "Enter Votes for District %d?"
    + " Enter Y to continue, N to stop.\n";
// Loop to "process" the votes in each precinct
for (int i = 1;; i++) {
  System.out.printf(msg, i);
  response = scan.next().toUpperCase();
  if (response.startsWith("N")) {
    break;
  }
  System.out.println("Enter votes for Polly: ");
  votesForPolly = scan.nextInt();
  totalPolly += votesForPolly;
  System.out.println("Enter votes for Ernest: ");
  votesForErnest = scan.nextInt();
  totalErnest += votesForErnest;
}
System.out.printf("Total votes for Polly is: %d\n"
      + totalPolly);
System.out.printf("Total votes for Ernest is: %d\n"
      + totalErnest);