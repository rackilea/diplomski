public String saveEmployee(Employee employee) {
    String result=null;
    PreparedStatement pstmt=null;
    try {
         pstmt = getDataComnConnection().prepareStatement(saveEmployeeQuery);
         pstmt.setString(1, employee.getFirstName());
         pstmt.setString(2, employee.getLastName());
         pstmt.setString(3, employee.getDisplayName());
         pstmt.setString(4,employee.getAltId());
         pstmt.setBoolean(5, employee.isActive());
         pstmt.setInt(6, employee.getDeptId());
         pstmt.setInt(7, employee.getTeamId());
         pstmt.setString(8, "abc");
         pstmt.setString(9, "def");
         pstmt.execute();
         pstmt.close();
         getDataComnConnection().close();
         result="Success";
    }
    catch (SQLException ex) {
        // TODO: handle exception
         result="Failure";
        ex.printStackTrace();
    }
    return result;