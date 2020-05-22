Class.forName("org.postgresql.Driver");

Connection connection = DriverManager.getConnection(
        "jdbc:postgresql://127.0.0.1:5432/testdb",
        "testdb",
        "testdb");

ResultSet rs = connection.prepareStatement("SELECT * FROM sal_emp").executeQuery();

rs.next();

java.sql.Array a1 = rs.getArray(2);
Integer[] o1 = (Integer[])a1.getArray();

java.sql.Array a2 = rs.getArray(3);
String[][] o2 = (String[][])a2.getArray();