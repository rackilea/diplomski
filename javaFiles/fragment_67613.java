String sql = "insert into textvalueinvertedindex (fileid, keyword) values (?,?)";
PreparedStatement pstmt = conn.prepareStatement(sql);
while (tokes.hasMoreTokens()) {
    keywords = tokens.nextToken();
    pstmt.setString(1, fileid);
    pstmt.setString(2, keyword);
    pstmt.executeUpdate();
}
pstmt.close();