Scanner scanner = new Scanner(System.in);
int number;
while(true) {
  try {
    System.out.println("Enter a number");
    number = Integer.parseInt(scanner.nextLine());
    break;
  } catch (NumberFormatException e) {
    System.err.println(e.getMessage());
  }
}