PreparedStatement ps = con.prepareStatement("SELECT file_name, content from data_table where *some condition*");
ResultSet rs = ps.executeQuery();
while(rs.hasNext) {
    rs.next();
    String fileName = rs.getString("file_name");
    Blob blob = rs.getBlob("content");
    byte[] content = blob.getBytes(1, (int) blob.length());
    //now content contains the data, you ca store it in a file if you need
    OutputStream os = new FileOutputStream(new File("d:/test/" + fileName));
    os.write(content);
    os.close();
}