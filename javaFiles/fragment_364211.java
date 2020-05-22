public class TestCustomerDao extends JdbcTemplate implements DepartmentDao {

    private static final String FOR_MAP 
                = "select DEPT_NAME,DEPT_CODE from DEPARTMENT where DEPT_ID = ?";

    @Override
    public Map<String, Object> getCoupleColumnsById(long id) {
        return (Map<String, Object>)queryForMap(FOR_MAP, new Object[] {id});
    }
}