public static void main(String[] args) {
    Payroll newEmpInfoObject = new Payroll();

    System.out.println("Enter name");
    Scanner keyboard = new Scanner(System.in);
    String name = keyboard.nextLine();
    System.out.println("Enter Address");
    String address = keyboard.nextLine();
    System.out.println("Enter Hourly Pay");
    double payrate = keyboard.nextDouble();
    System.out.println("Enter Hours Worked");
    double hours = keyboard.nextDouble();
    System.out.println("Enter Weeks");
    int week = keyboard.nextInt();

    Payroll pay=new Payroll();

    pay.printEmpInfo(name,address);
    System.out.println(pay.getGrossPayEarned(payrate,hours,week));
}