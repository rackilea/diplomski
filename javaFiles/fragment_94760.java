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
    //rdr.close(); this is why... you broke it :)       <-------------------SEE
    return new Employee(tmpid, tmpname, tmpsalary);
}