public class UserBean {
    public String name;
    public String role;
}

class Dao{
    ArrayList<UserBean> a= new ArrayList<UserBean>();
    String sql = "Select * from user";
    ResultSet rs = pStmt.executeQuery(sql);
    while(rs.next()){
        UserBean ub = new UserBean();
        ub.name=rs.getString("name");
        ub.role=rs.getString("role");
        a.add(ub);

    }
}