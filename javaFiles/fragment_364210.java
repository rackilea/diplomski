public class DepartmentDaoImpl extends JdbcTemplate implements DepartmentDao {

    private static final String DEPT_BY_ID 
                          = "select * from DEPARTMENT where DEPT_ID = ?";

    @Override
    public Department getDepartmentById(long id) {
        return (Department) queryForObject(
             DEPT_BY_ID, 
             new Object[] { id },
             new RowMapper<Department>() {
                 @Override
                 public Department mapRow(ResultSet rs, int rowNumber) {
                     Department dept = new Department();
                     dept.setId(rs.getLong("DEPT_ID");
                     dept.setDeptName(rs.getString("DEPT_NAME");
                     dept.setDeptCode(rs.getString("DEPT_CODE");
                     // set other properties

                     return dept;
                 }
             });
    }
}