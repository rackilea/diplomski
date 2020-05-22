Scanner input = new Scanner(System.in);
System.out.println("Please enter the first name last name and age of the person: ");
System.out.println("(first last age)");
String line = input.nextLine();
Scanner scan = new Scanner(line);
String first = scan.next();
String last = scan.next();
int age = scan.nextInt();
System.out.printf("Person: %s, %s (%d)%n", last, first, age);