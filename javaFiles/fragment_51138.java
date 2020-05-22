public class GetDataDAO extends BaseDAO {

  Connection con = getConnection();
  Statement stmts = null;
  String query = "select  userid, username, name , address, hairstyle from saloonuser ";
  stmts = con.createStatement();
  ResultSet rs = stmts.executeQuery(query);
  int li_row = 0;
  while(rs.next()){
    mysTable.setValueAt(rs.getString("username"),li_row,0);
    mysTable.setValueAt(rs.getString("name"),li_row,1);
    mysTable.setValueAt(rs.getString("address"),li_row,2);
    mysTable.setValueAt(rs.getString("hairstyle"),li_row,3);

    int userid = rs.getInt("userid");
    String username = rs.getString("username");
    String name1     = rs.getString("name");
    System.out.println(name1);
    li_row++;
    }
  }