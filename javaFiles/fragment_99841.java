public void groupCreation(String groupname, int grouptype, int creator_id) {

    DatabaseService oDatabaseService = new DatabaseService();
    Connection connection = oDatabaseService.connect();
    Statement stmt = null;
    Statement stmt2 = null;
    Statement stmt3 = null;
    try {
        //Statement stmt = null;            
        stmt = connection.createStatement();
        String sql;


        sql = "INSERT INTO M_GROUPS(GROUP_NAME,GROUP_CREATOR_ID,GROUP_TYPE,CREATION_TIME)"
                + " VALUES ('"
                + groupname
                + "','"
                + creator_id
                + "','"
                + grouptype + "',NOW())";

       stmt.executeUpdate(sql);
       stmt.close();



    stmt2 = connection.createStatement();
    String sql2;

    sql2 ="select max(group_id)as group_id from m_groups where group_creator_id='"+ creator_id+ "'";

    //System.out.println("before rs for sql2");
    ResultSet rs = stmt2.executeQuery(sql2);
    //System.out.println("after rs for sql2");

    int groupId = 0 ;

    while (rs.next()) {
    groupId =rs.getInt("group_id");
    }

    System.out.println(groupId);

    stmt3 = connection.createStatement();
    String sql3;

     sql3 = "INSERT INTO M_GROUP_MEMBERS(GROUP_ID,MEMBER_ID,JOIN_TIME)"
            + " VALUES ('"
            + groupId
            + "','"
            + creator_id
             + "',NOW())";

    stmt3.executeUpdate(sql3);


    } catch (SQLException se) {
        se.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try{
             if(stmt!=null)
                stmt.close();
          }catch(SQLException se2){
          }// nothing  can do
        try{
             if(stmt2!=null)
                stmt2.close();
          }catch(SQLException se3){
          }// nothing  can do

        try{
             if(stmt3!=null)
                stmt3.close();
          }catch(SQLException se4){
          }// nothing  can do
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}