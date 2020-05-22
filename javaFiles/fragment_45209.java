Connection cn = //..
// Very important - JDBC default is to commit after every statement
// which will cause DB to close the cursor
cn.setAutoCommit(false);
Statement st = cn.prepareStatement("SELECT * FROM TBL_FOO");

// Cache 50 rows at the client at a time
st.setFetchSize(50);
ResultSet rs = st.executeQuery();
while (rs.next()) {
    // Move the cursor position forward - moving past cached rows triggers another fetch
}
rs.close();
st.close();