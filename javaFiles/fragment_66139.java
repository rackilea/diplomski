public List<Employee> getEmployees(){
    final String sql = "CALL employees_procedure";
    final List<Employee> employees = (Employee) jdbcTemplate.queryForList("CALL employees_procedure", new EmployeeRowMapper());

    return employees ;
}

public class EmployeeRowMapper implements RowMapper {
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee= new Employee ();
        employee.set(rs.getString("e.id"));
        ...
        return employee;
    }
}