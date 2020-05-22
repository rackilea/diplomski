String query = "SELECT rocks FROM something WHERE idSomething='" + idSomething+ "'";

Class.forName("com.mysql.jdbc.Driver").newInstance();
String url = "jdbc:mysql://localhost:3306";
Connection conn = DriverManager.getConnection(url, "root", "root");
Statement stmt = conn.createStatement();

ResultSet rs;
rs = stmt.executeQuery(query);

String result = "";

while (rs.next()) {
    //'col1' refers to the value in each row in a column called col1 in you table
    result += rs.getString("col1");
}