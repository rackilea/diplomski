public static void listAllEmployeeByField(List<Employee> list, int... fields) {
    System.out.println("Listin all empoyee by fields "+ Arrays.toString(fields) + ":");
    for (Employee emp : list) {
        System.out.println(emp.selectField(fields));
    }
}