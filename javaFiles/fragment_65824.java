Department department = new Department();
department.setEmployeesInThisDepartment(new ArrayList<>());

jdbcTemplate.queryForObject(sql, map, (rs, rowNum) -> {
        department.setId(rs.getLong("department.id"));
        department.setDepartmentName(rs.getString("department.departmentName"));

        Employees employees = new Employees();
        employees.setId(rs.getLong("employees.id"));
        employees.setFullName(rs.getString("employees.fullName"));
        employees.setDepartment(rs.getString("employees.department"));
        employees.setBirthday(rs.getDate("employees.birthday"));
        employees.setSalary(rs.getInt("employees.salary"));
        department.getEmployeesInThisDepartment().add(employees);
});
return department;