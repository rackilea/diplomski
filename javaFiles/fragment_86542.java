try (
        Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost/linkedDB?user=postgres&password=whatever");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT f FROM test_pdf WHERE id='2'");
        FileOutputStream fos = new FileOutputStream("C:/Users/Gord/Desktop/retrieved.pdf")) {
    rs.next();
    byte[] fileBytes = rs.getBytes(1);
    fos.write(fileBytes);
} catch (Exception e) {
    e.printStackTrace(System.err);
}