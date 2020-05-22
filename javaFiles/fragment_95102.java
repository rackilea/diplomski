public static double maxPayment(List<Employee> list) {
    return list.stream().mapToDouble(Employee::getPayment).max().getAsDouble();
}

public static double maxExperience(List<Employee> list) {
    return list.stream().mapToDouble(Employee::getExperience).max().getAsDouble();
}

public static void main(String[] args) {
    Manager manager = new Manager("Sue", 23, 3500);
    Manager manager1 = new Manager("John", 22, 3000);
    Manager manager2 = new Manager("Q", 12, 3200);
    Manager employee1 = new Manager("Fred", 2, 3000);
    List<Employee> list = new ArrayList<>(Arrays.asList(manager, manager1, manager2,employee1));

    System.out.println(Manager.maxPayment(list));      //3500.0
    System.out.println(Manager.maxExperience(list));   //23.0
}