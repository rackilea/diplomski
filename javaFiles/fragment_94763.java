public static class Employee implements  Serializable {

    private int id;
    private String name;
    private BigDecimal salary;

    public Employee(int id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

}

static Employee getData(Scanner scanner) throws IOException {

    System.out.printf("Enter Employee ID : ");
    while ( !scanner.hasNextInt() ) {
        System.out.println("Employee IDs are numbers only");
        scanner.next();
    }

    int employeeId = scanner.nextInt();

    System.out.printf("Enter Employee Name : ");
    String name = scanner.next();


    System.out.printf("Enter Employee Salary : ");

    while ( !scanner.hasNextBigDecimal() ) {
        System.out.println("Employee salaries are decimals " +
                "not random gak");
        scanner.next();
    }
    BigDecimal salary = scanner.nextBigDecimal();

    return new Employee(employeeId, name, salary);
}


public static void main(String []args) throws Exception {
    boolean moreRecords = true;
    String path = null;
    Scanner scanner = new Scanner(System.in);
    File file = null;
    System.out.printf("Enter path to save your file : ");
    path = scanner.next();
    file = new File(path);


    while (moreRecords) {
        Employee rec = Main.getData(scanner);

        try ( ObjectOutputStream dos =
                      new ObjectOutputStream(
                            new FileOutputStream(file) ) ) {
            dos.writeObject(rec);

        }

        System.out.printf("Add more records [true/false]? ");
        moreRecords = scanner.nextBoolean();