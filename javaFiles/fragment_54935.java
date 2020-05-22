private StreamedContent txtFile;
        public void createTxt(ActionEvent actionEvent) {

try {
    Class.forName("com.mysql.jdbc.Driver");
    StringBuilder builder = new StringBuilder();
    conn = DriverManager.getConnection(DB_URL, USER, PASS);
    stmt = conn.createStatement();

    String sql = "SELECT id, name, amount FROM Employee";
    ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            int id  = rs.getInt("id");
            int age = rs.getString("name");
            String first = rs.getInt("amount");
            builder.append(id+"|"+age+"|"+first+"\n");
           } 
        rs.close();
        String result = builder.toString();
    InputStream inputStream = new ByteArrayInputStream(result.getBytes(Charset.forName("UTF-8")));
    txtFile = new DefaultStreamedContent(inputStream, "application/txt", "sample.txt");
} catch (Exception e) {
    e.printStackTrace();
}

}