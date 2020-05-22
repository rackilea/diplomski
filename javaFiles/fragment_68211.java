public static Predicate<Employee> isAdultMale() {
    return e -> ((Predicate<Employee>)EmployeePredicates::isAgeMoreThan21).test(e) && ((Predicate<Employee>)EmployeePredicates::isMale).test(e);
}

private static boolean isAgeMoreThan21(Employee employee) {
    return employee.getAge() > 21;
}

private static boolean isMale(Employee employee) {
    return employee.getGender().equalsIgnoreCase("M");
}