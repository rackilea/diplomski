try (
    Connection connection = dataSource.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT SQL_CALC_FOUND_ROWS * FROM tablets limit " + offset + ", " + noOfRecords + ";");
    ResultSet resultSet = preparedStatement.executeQuery();
    ResultSet resultSet1 = connection.createStatement().executeQuery("SELECT FOUND_ROWS()"); // ****
    ) {
    while (resultSet.next()) {
        tablet = new Tablet();
        tablet.setTabletId(resultSet.getInt("idTablet"));
        tablet.setName(resultSet.getString("name"));
        tablet.setNeedRecepie(resultSet.getBoolean("need_recipe"));
        tablet.setPrice(resultSet.getDouble("price"));
        tablet.setTypeId(resultSet.getInt("type_id"));
        tablet.setDescription(resultSet.getString("description"));
        tablet.setTabletType(TypeFactory.getType(tablet.getTypeId()));
        tablet.setWeight(resultSet.getDouble("weight_of_pack"));
        tablet.setPillsCount(resultSet.getInt("pills_count"));
        tabletSet.add(tablet);
    }
    if (resultSet1.next())
        this.noOfRecords = resultSet1.getInt(1);
} catch (SQLException e) {
    e.printStackTrace();
}