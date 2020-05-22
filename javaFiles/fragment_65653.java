Scanner sc = new Scanner(System.in);
System.out.print("Please enter an int: ");
String s = sc.next();
while(!s.matches("\\d+")) {
    System.out.println("Input is not valid! Re enter an integer!");
    System.out.print("Please enter an int: ");
    s = sc.next();
}
int numWeight = Integer.parseInt(s);
System.out.println("Int: " + numWeight);