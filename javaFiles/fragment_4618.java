public class SomeDao {
    private Connection con;
    //using Dependency Injection by composition for DAO classes with connection
    public SomeDao(Connection con) {
        this.con = con;
    }
    public SomeEntity getSomeEntity(int id) {
        String sql = "SELECT id, col1, col2 FROM someEntity WHERE id = ?";
        //PreparedStatement and ResultSet go on the narrowest possible scope
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        SomeEntity someEntity = new SomeEntity();
        if (rs.hasNext()) {
            someEntity.setId(rs.getInt("id");
            //similar for other columns...
        }
        //don't forget to close the resources after its usage
        return someEntity;
    }
}

public class SomeService {
    public SomeEntity getSomeEntity(int id) {
        //retrieving the connection at this level
        //a service may access to several daos
        Connection con = ConnectionProvider.getConnection();
        //performing the operations against DAO layer
        SomeDao someDao = new SomeDao(con);
        SomeEntity someEntity = someDao.getSomeEntity(id);
        //closing the connection. This is A MUST
        //here the connection pool won't close the physical connection
        //instead put it to sleep
        con.close();
        //return the proper data at a single point of the method
        return someEntity;
    }
}