Scanner scan = new Scanner(System.in);
int intValue;
double decimalValue;
String textValue;

System.out.println("Please enter an integer value");
intValue = scan.nextInt(); // see how I use nextInt() for integers
System.out.println("Please enter a real number");
decimalValue = scan.nextDouble(); // nextDouble() for real numbers
System.out.println("Please enter a string value");
textValue = scan.next();    // next() for string variables

System.out.println("Your integer is: " + intValue + ", your real number is: "
                                + decimalValue + " and your string is: " + textValue);