public List<Employee> getEmployeesBySearchCriteria(String criteria) {

    String sql = "SELECT firstname, lastname FROM employees WHERE UPPER(firstname) LIKE UPPER(?)";

    return getEmployeeList(sql, "%" + firstname + "%");

}