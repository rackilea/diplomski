try {
    Class.forName("com.mysql.jdbc.Driver");
    String host = "jdbc:mysql://xx2-23-x1-2x1-172.compuxe-1.xmazonaws.com:3306/xxxxx";
    conn = DriverManager.getConnection(host,"xxxxx","xxxxx");
} catch (Exception e) {
    e.printStackTrace();
}