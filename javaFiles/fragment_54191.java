final Map<Integer, Department> departments = new HashMap<Integer, Department>();
this.jdbcTemplate.query(
    "select d.deptid, d.deptname, e.empid, e.empname from Department d inner join Employee on e.deptid = e.deptid",
    new RowMapper<Employee>() {
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Integer deptId = rs.getInt("deptid");
            Department d = (Department) departments.get(deptId);
            if (d == null) {
                String deptName = rs.getString("deptname");
                d = new Department();
                d.setDeptId(deptId);
                d.setDeptName(deptName);
                departments.put(deptId, d);
            }
            Employee employee = new Employee();
            employee.setEmpId(rs.getInt("empid"));
            employee.setEmpName(rs.getString("empname"));
            employee.setDeptId(deptId);
            d.getEmployees().add(employee);
            return employee;
        }
    });
List<Department> result = new ArrayList<Department>(departments.values());