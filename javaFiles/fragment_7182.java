Integer limit = 50000;
Integer offset = 0;
String query= "SELECT COUNT(*) as total FROM myTable";
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(query);
Integer total = rs.getInt("total");
Integer itrCount = (int) Math.ceil((double) total/limit);

for(int i=0; i< itrCount; i++){
    String query1 = "SELECT * FROM myTable limit " + limit + " offset " + offset;
    Statement st1 = conn.createStatement();
    ResultSet rs1 = st1.executeQuery(query1);
    ResultSetMetaData rsmd =  rs1.getMetaData();
    int columnsNumber = rsmd.getColumnCount();
    List<String> list = new ArrayList<String>();

    while (rs1.next()) {
      for(int i=0;i<columnsNumber;i++){
            String row= ""
            String row= row + " "+ rs1.getString(i);
       }

       list.add(row);
    }        

    offset += limit;

    // do something with your list
}