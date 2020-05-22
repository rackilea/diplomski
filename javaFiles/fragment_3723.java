ResultSet rs = preparedStatement.executeQuery();

while (rs.next()) {
        Integer curr = rs.getInt("Curr");
        // Do something here
}