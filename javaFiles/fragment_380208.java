Scanner keyboard = new Scanner(System.in);

System.out.println("Employee Name:");
String name = keyboard.nextLine();

System.out.println("Employee #:");
String employeeNumber = keyboard.nextLine();

System.out.println("Hire Date:");
String hireDate = keyboard.nextLine();

System.out.println("Shift 1 or 2:");
int shift = keyboard.nextInt();

System.out.println("Pay Rate:");
double payRate = keyboard.nextDouble();

ProductionWorker worker = 
    new ProductionWorker(name, employeeNumber, hireDate, shift, payRate);

System.out.println(worker);