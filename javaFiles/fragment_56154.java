List<Product> list = new ArrayList<>();
try (Connection connection = openConnection()) {
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, appId);
        try (resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Product item = getProductById(resultSet.getInt("prodId"));
                list.add(item);
            } 
            return list;
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}