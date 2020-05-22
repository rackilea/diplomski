public class RegisterAction {
   ....
    public String execute(){
    ...
    }

    public List<User> getAllUsers() {
    List<User> users = new ArrayList<User>();
    Connection con=RegisterDao.con;
    try
    {
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from STRUTSUSER");
        while (rs.next())
        {
            User user = new User();
            user.setID(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("pass"));
            user.setEmailID(rs.getString("emailid"));
            users.add(user);
        }
    } 
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    return users;
   }

    public String delete() {
      HttpServletRequest request ServletActionContext.getRequest();
      int userId = request.getParameter("id");
      deleteUser(userId);
      return SUCCESS;
     }

    private void deleteUser(int userId)
        {
            Connection con=RegisterDao.con;
            try
            {
               PreparedStatement ps = conn.prepareStatement("delete from STRUTSUSER where id=?");
                // Parameters start with 1
                ps.setInt(1, userId);
                ps.executeUpdate();

            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
     }