public EmployeeEntity getEmployees(String firstName, String lastName) {
    QEmployeeEntity employee = QEmployeeEntity.employeeEntity;
    BooleanBuilder where = new BooleanBuilder();
    if (firstName != null) {
        where.and(employee.firstName.eq(firstName));
    }
    if (lastName != null) {
        where.and(employee.lastName.eq(lastName));
    }
    return empployeeDAO.findAll(where);
}