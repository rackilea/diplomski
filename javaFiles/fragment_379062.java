// Database URL including driver, username, password, database name etc.
    String URL = "jdbc:oracle:thin:username/password@amrood:1521:EMP";
    Connection conn = DriverManager.getConnection(URL);
    // Create your SQL Query.
    PreparedStatement st = conn.prepareStatement("UPDATE YourTable SET YourColumn = 12 WHERE TableID = 1337");
    // Execute (If your statement doesn't need to return results).
    st.execute();