Scanner sc = new Scanner(System.in);
System.out.println("Enter the first number:");
String first = sc.next();
System.out.println("Enter the second number:");
String second = sc.next();
int combinedNumber = Integer.parseInt(first + second);
System.out.println("You entered the number: " + combinedNumber);