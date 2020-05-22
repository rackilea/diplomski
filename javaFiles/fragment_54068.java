public ArrayList<String> findPath(String roomName) throws SQLException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException
{
    ArrayList<String> path = new ArrayList<String>(); 
    connection = getConnection();
    String queryPattern = "SELECT Livello_1, Livello_2, Livello_3, Livello_4 FROM Camera WHERE Camera.Nome = ?";
    PreparedStatement queryStatement = connection.prepareStatement(queryPattern);
    queryStatement.setString(1, roomName);
    ResultSet rs = queryStatement.executeQuery();
    if(rs.next())
    {
        for(int i = 1; i < 4; i++)
        {
            path.add(rs.getString(i));
        }
    }
    return path;
}