Scanner scanner = new Scanner(System.in);
System.out.println("Enter your first and last name");
fName = scanner.next();
lName = scanner.next();
return "Hello " + fName + " " + lName;
// can also be String.format("Hello %s %s", fName, lName);