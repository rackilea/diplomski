public class MasterDetailResultSetExtractor implements ResultSetExtractor {

  @Override
  public Object extractData(ResultSet rs) throws SQLException {
    Master m = new Master();
    m.setFirstName(rs.getString(1));
    m.setLastName(rs.getString(2));

    //put the master in a map

    Detail d = new Detail();
    d.setSomeProp(rs.getString(3));

    //check if the master is in the map
        //if yes - add the detail to the master
        //if no - add the master first
    return m;
  }

}