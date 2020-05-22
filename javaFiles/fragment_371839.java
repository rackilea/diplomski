public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a number:");
    int num = input.nextInt();
    input.nextLine();
    System.out.println("Enter a name list:");
    String nameList = input.nextLine();
    System.out.println("Enter last name:");
    String lastName = input.nextLine();
    input.close();
    System.out.println(num + " * " + nameList + " ** " + lastName);
}