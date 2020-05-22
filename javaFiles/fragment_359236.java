public static void main(String... args) throws Exception {
    DeleteDbFiles.execute("~", "test", true);

    Class.forName("org.h2.Driver");
    try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test"); 
            Statement stat = conn.createStatement()) {
        stat.execute("create table test(id int primary key, name varchar(255))");
        stat.execute("insert into test values(1, 'Hello')");
        try (ResultSet rs = stat.executeQuery("select * from test")) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}