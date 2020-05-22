public static class Employee implements  Serializable {

    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

}

static Employee getData() throws IOException {
    BufferedReader rdr = new BufferedReader(
            new InputStreamReader(
                    new DataInputStream(System.in)
            ));
    System.out.printf("Enter Employee ID : ");
    int tmpid = Integer.parseInt(rdr.readLine());
    System.out.printf("Enter Employee Name : ");
    String tmpname = rdr.readLine();
    System.out.printf("Enter Employee Salary : ");
    int tmpsalary = Integer.parseInt(rdr.readLine());
    //rdr.close(); this is why... you broke it :)
    return new Employee(tmpid, tmpname, tmpsalary);
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
        Employee rec = Main.getData();
        ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream(file));
        dos.writeObject(rec);
        dos.close();
        System.out.printf("Add more records [true/false]? ");
        moreRecords = scanner.nextBoolean();
    }