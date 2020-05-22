PreparedStatement ps = null;
ResultSet resultSet = null;
ps = connection.prepareStatement("Select * from Users Us");
resultSet = ps.executeQuery();
while (resultSet.next()) {
    //take the field and do something with it. You can take something with construction "resultSet.getInt("Us.id")"
}