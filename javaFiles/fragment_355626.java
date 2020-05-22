Employee[] employees = new Employee[noOfEmployees]

for(int i = 0; i < noOfEmployees; i++){
    Name name = new  Name(String first, String last);
    Address address = new Address(String street, String city, String state, int zipCode);
    Date hireDate = new  Date(int eMonth, int eDay, int eYear);
    employees[i] = new Employee(name,address,hireDate);
}