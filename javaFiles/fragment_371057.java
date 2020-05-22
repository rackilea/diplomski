public List<Employee> getAllEmployee() {
    Connection con = null;
    ResultSet rs = null;
    List<Employee> lstEmployee = new ArrayList<Employee>();
    try {
        con = mySqlDbConnection.getConnection();
        //write the sql to retrieve all the data
        //I'm assuming these can be your columns, it's up to you
        //this can be written using JOINs...
        String sql = "SELECT E.EMPLOYEE_ID, E.EMPLOYEE_NAME, P.PROJECT_NAME, R.REPORT_NAME FROM EMPLOYEE E, PROJECT P, REPORT R WHERE E.EMPLOYEE_ID = P.EMPLOYEE_ID AND E.EMPLOYEE_ID = R.EMPLOYEE_ID";
        //I guess you don't need parameters for this...
        rs = SqlDbEngine.executeSQL(con, sql, null);
        if (rs != null) {
            Employee e;
            int employeeId = -1, lastEmployeeId = -1;
            while (rs.next()) {
                //you need to make sure to create a new employee only when
                //reading a new employee id
                employeeId = rs.getInt("EMPLOYEE_ID");
                if (lastEmployeeId != employeeId) {
                    e = new Employee();
                    lastEmployeeId = employeeId;
                    lstEmployee.add(e);
                }
                Project p = new Project();
                Report r = new Report();
                //fill values of p...
                //fill values of r...
                //you can fill the values taking advantage of the column name in the resultset
                //at last, link the project and report to the employee
                e.getProjects().add(p);
                e.getReports().add(r);
            }
        }
    } catch (Exception e) {
        //handle the error...
    } finally {
        try {
            if (rs != null) {
                Statement stmt = rs.getStatement();
                rs.close();
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            //handle the error...
        }
    }
    return lstEmployee;
}