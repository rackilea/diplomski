try{
    final String sql = "SELECT Name FROM users;";

    PreparedStatement ps = connection.prepareStatement(sql);
    ResultSet rs = ps.executeQuery();
    if(rs != null){
        while(rs.next()){
            String name = rs.getString(1);
            //Do something with name
        }
        rs.close();
    }
    ps.close();
}catch(Exception e){
    e.printStackTrace();
}