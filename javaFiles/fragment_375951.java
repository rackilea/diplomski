Scanner scan = new Scanner(System.in);
int choice = 0;
System.out.print("Please enter a choice: ");
int reloop = 0;
do {
  try {
    String input = scan.nextLine(); // Scan the next line from System.in
    choice = Integer.parseInt(input); // Try to parse it as an int
    reloop++;
  } catch (Exception e) {
    System.out.println("Please enter a number!");
  }
} while (reloop == 0);