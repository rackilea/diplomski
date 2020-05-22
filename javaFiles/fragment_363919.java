public List<Types> getTypes(String type) {
     Connection con = getConnection();
     String Query = "select * from ABC";
     List<Types> list=new ArrayList();
     rs = con.createStatement().executeQuery(Query);

      while (rs.next()) {
         Types type=new Types();
         type.setName(rs.getString(1));
         type.setPcaNo(rs.getString(2));
         type.setIp(rs.getString(3));
         list.add(type);
      }
      rs.close();
      con.close();
    return list;
  }