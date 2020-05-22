Scanner scanner = new Scanner(System.in);
String line;
System.out.println("Ask away. Type 'stop' to exit.");
while (!"stop".equals((line = scanner.nextLine()))) {
    System.out.println("Neat");
}