public class H2ExpEval {
    public static void main(String... args) throws Exception {
        evaluateUsingH2("SELECT 2+2");
        evaluateUsingH2("SELECT 3+7-5");
        evaluateUsingH2("SELECT 2*2*2+1");
    }

    private static void evaluateUsingH2(String sql) throws Exception {
        Class.forName("org.h2.Driver");
        // opens an in-memory database: no files are saved and it's all quicker
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:");
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        if (rs.next()) {
            System.out.println(rs.getString(1));
        }
        stat.close(); conn.close();
    }
}