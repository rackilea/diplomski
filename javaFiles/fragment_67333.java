public static void main(String[] args) throws FileNotFoundException {
    printHeading(); 

    Scanner file1 = new Scanner(new File("C:\\Users\\nupur\\workspace\\Project2\\src\\EmployeesIn.dat")) ;
    System.out.println("New Employee added: Pryce, Lane");
    System.out.println("New Wages: ");
    while(file1.hasNextLine()) {
        System.out.println("Wage = " + file1.nextLine().replaceAll("[\\D]", "")) //replace all non-digit characters with blank
    }
}