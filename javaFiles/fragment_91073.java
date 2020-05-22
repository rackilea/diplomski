List<String> listOfSomething;
ResultSet rs = statement.executeQuery(query);
while (rs.next()) {
    String current = rs.getString("whatever");
    listOfSomething.add(current);
}