private static void printEmployees(Employee[] employees){
    for (Employee employee : employees) {
        System.out.println("ID: "+employee.getIdNumber());
        System.out.println("Name : "+employee.getFirstName()+" "+employee.getLastName());
        System.out.println("------------------------------------");
    }
}