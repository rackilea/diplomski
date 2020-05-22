Connection con = DriverManager.getConnection(dbUrl,user,pass);
try (Statement st = con.createStatement()) {
    ResultSet rs = st.executeQuery(sqlQuery1);
    simplePrint(rs);
} catch (SQLException e) {
    e.printStackTrace();
}//here `st` will be closed automatically by try-with-resources

try (Statement st = con.createStatement()) {//lets try to create next statement
    ResultSet rs = st.executeQuery(sqlQuery2);
    simplePrint(rs);
} catch (SQLException e) {
    e.printStackTrace();
}