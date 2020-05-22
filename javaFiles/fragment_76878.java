int recordId;
double i,j;
double array=0;
ResultSet rs = stmt1.executeQuery("SELECT primaryKey, a3, a4 FROM rssi");
while (rs.next()) {
    recordId = rs.getInt("primaryKey");
    i= rs.getInt("a3");
    j= rs.getInt("a4");
    if(j==0){
        array=0;
    }else{
        array=((i/(j/10))-112);
    }
    String query3="UPDATE rssi set result ="+array+" WHERE primaryKey = "+recordId;
    pst1 = (PreparedStatement) conn.prepareStatement(query3);
    pst1.execute();

}

conn.commit();
conn.close();
System.out.println("Success insert result to mysql table");