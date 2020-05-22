Scanner input = new Scanner(System.in);
do {
    System.out.print("  >: ");
    System.out.flush();
    String pass = input.nextLine();
    if (pass.equals("0286139")) {
        break;
    }
    System.out.println(" ------------------------------------- ");
    System.out.println("     Incorrect password. Try again.    ");
    System.out.println(" ------------------------------------- ");
} while (true);