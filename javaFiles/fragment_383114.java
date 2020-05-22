public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Month?");
    int month = scan.nextInt();
    scan.nextLine();
    System.out.println("Year?");
    int year = scan.nextInt();
    scan.nextLine();
    System.out.println(getNumberOfDays(month, year));
}