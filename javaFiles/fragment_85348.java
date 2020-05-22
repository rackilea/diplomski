private void writeToDB(Connection conn, String fileName, InputStream is, String description) 
    throws SQLException {

    String sql = "Insert into Attachment(Id,File_Name,File_Data,Description) "
            + " values (?,?,?,?)";

    try (PreparedStatement pstm = conn.prepareStatement(sql)) {

        Long id = this.getMaxAttachmentId(conn) + 1;
        pstm.setLong(1, id);
        pstm.setString(2, fileName);
        pstm.setBinaryStream(3, is);
        pstm.setString(4, description);
        pstm.executeUpdate();
   }
}