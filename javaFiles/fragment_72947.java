String query = "select * from Database WHERE Approved ='Approved'";
if(null != productname && !"".equals(productname)) {
      query += " AND Product = '"  +productname+"'";
}
if(null != productuse && !"".equals(productuse)) {
      query += " AND USES = '"  +productuse+"'";
}