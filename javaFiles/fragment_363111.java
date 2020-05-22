try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("com.mysql.jdbc:mysql://localhost:3306/NewStudents", "root", "root");

        Statement st = con.createStatement();
        ResultSet result = st.executeQuery("select * from students");

        while (result.next()) {
            .....
        }
    }
    catch (ClassNotFoundException e) {
        System.out.println("Driver not found");
    }
    catch (SQLException e) {
        e.printStackTrace();