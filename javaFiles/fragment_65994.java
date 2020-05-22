String consulta = "SELECT COUNT(*) FROM Perit WHERE LOGIN = ? AND PASSWORDMD5 = MD5(?);"
try(PreparedStatement pstmt = con.prepareStatement(consulta))
{
    pstmt.setString(1, login); 
    pstmt.setString(2, pass); 
    try(ResultSet rs = pstmt.executeQuery())
    {
        count = rs.getInt(1);
    }
} 
catch (SQLException ex) 
{
    Logger.getLogger(JDBCMySQL.class.getName()).log(Level.SEVERE, null, ex);
}