PreparedStatement st = connection.prepareStatement("DELETE FROM Table WHERE name = ?");
st.setString(1,name);
st.executeUpdate(); 

// your full code after Proper PreparedStatement

public static void DeleteRow(String name) {
    try {  
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement st = connection.prepareStatement("DELETE FROM Table WHERE name = ?");
        st.setString(1,name);
        st.executeUpdate(); 
    } catch(Exception e) {
        System.out.println(e);
    }
}