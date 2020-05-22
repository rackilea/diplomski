String username = request.getParameter("username");
  String password = request.getParameter("password");

try(Connection conn= MyUtil.getConnection()){

              PreparedStatement pst = conn.prepareStatement("insert into customer (username,password) values (?,?);");  
               pst.setString(1, username);
               pst.setString(2, password);

                pst.executeUpdate();    

          }catch (SQLException e) {
                e.printStackTrace();
            }