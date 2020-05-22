//Load jdbc driver
        Class.forName("com.mysql.jdbc.Driver");

        //Open a connection to server   
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8", USERNAME, PASSWORD);

        //Create statement for query
        Statement stmt = (Statement) conn.createStatement();  

        //create table column with character set utf 8
        stmt.executeUpdate("CREATE TABLE table1 (id int,name varchar(20) character set utf8);");

        //INSERT query
        stmt.executeUpdate("INSERT INTO table1 (id,name) VALUES ('12','汉语')");

        //SELECT query
        ResultSet rs=stmt.executeQuery("SELECT * FROM table1");
        System.out.println(rs.getString("name"));