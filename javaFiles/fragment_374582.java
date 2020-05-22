Scanner input = new Scanner(System.in);
System.out.print("  >: ");
System.out.flush();
String pass;
while (!(pass = input.nextLine()).equals("0286139")) {
    System.out.println(" ------------------------------------- ");
    System.out.println("     Incorrect password. Try again.    ");
    System.out.println(" ------------------------------------- ");

    System.out.print("  >: ");
    System.out.flush();
}