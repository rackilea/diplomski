Scanner in = new Scanner(System.in);
System.out.println("Enter a string:");
String enteredString = in.next();
for (int i = 1; i < enteredString.length(); i+=2) {
    System.out.println(enteredString.charAt(i));
}