Timestamp result = null;

Statement st = connection.createStatement();
ResultSet rs = st.executeQuery("SELECT ts FROM MYTABLE WHERE ...");
if (rs.next()) {
    result = rs.getTimestamp(1);
}