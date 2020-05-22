Connection conn = ConnectionBean.getInstance().getDBConnection();
int counter=0;
String fileLine;
BufferedReader in;
String query1 = "select id from test"; // get all the id's from the table you wanna do  the update
ArrayList<Integer> al = new ArrayList<Integer>(); // store them in an arraylist
try {
PreparedStatement stmnt = conn.prepareStatement(query1);
ResultSet rs = stmnt.executeQuery();
while(rs.next()) {
    al.add(rs.getInt("id"));
}
}
catch(Exception ex) {
    ex.printStackTrace();
}

try {
    in = new BufferedReader(new FileReader("file1.txt"));
    int h=1;
    while((fileLine=in.readLine())!=null && al.size()>0)  
    {   

        String query="UPDATE chaitu.test SET col=? WHERE id="+h ;
        PreparedStatement statement = conn.prepareStatement(query);

        statement.setString(1, fileLine);
        statement.executeUpdate();
        h++;
    } //end while loo


} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (SQLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
    }