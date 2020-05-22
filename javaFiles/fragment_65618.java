try {
         ArrayList<String> A = new ArrayList<String>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "123456");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT Password FROM workers");

        while(rs.next())  
        {
          A.add(rs.getString("Password"));

        }
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }