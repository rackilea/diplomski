private static List<Color> query(Connection connection) throws SQLException{
    List<Color> colors = new LinkedList();
    ...
    while(resultSet.next()) {
        Color color = new Color();
        color.setName(resultSet.getString(rsltmetadata.getColumnName("color"));
        color.setId(resultSet.getString(rsltmetadata.getColumnName("id"));
        colors.add(color);
    }
    return colors;
}