public static void main(String[] args) {
    PayInfo info = ...;
    Address address = ...;
    Details details = new Details(info, address);

    String name = ...
    Employee employee = new Employee(name, details);

    Personnel personnel = new Personnel();
    personnel.addEmployee(employee);

    //example
    Details employeeDetails = personnel.getEmployeeDetails("Some Name");
    Address employeeAddress = employeeDetails.getAddress();
    System.out.println(employeeAddress.getStreetAddress());
}