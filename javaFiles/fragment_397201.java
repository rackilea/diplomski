public ResultSet executeSearch(String q){
    openConnection();
    try {
        return connection.createStatement().executeQuery(q);
    } catch (Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return null;
}

public int getAddressID(String city) throws SQLException{
    ...
    try (ResultSet rs = executeSearch(q)) {
        ...
    } finally {
         closeConnection();
    }
    return i;
}