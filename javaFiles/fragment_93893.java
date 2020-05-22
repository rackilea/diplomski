public static void main(String[] args) {
    // provide a query as String
    String query = "SELECT ParentName, ChildName FROM some_table";
    // provide the data structure
    Map<String, List<String>> results = new HashMap<>();
    // connect to your database
    Connection connection; // this has to be created using a suitable JDBC implementation

    try (PreparedStatement ps = connection.prepareStatement(query)) {
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String parentName = rs.getString(1);
            String childName = rs.getString(2);

            // add them to the map
            if (results.containsKey(parentName)) {
                /* 
                 * if the key already exists in the map, 
                 * just add the current name to its value(s)
                 */
                results.get(parentName).add(childName);
            } else {
                // create a new list as the value for the new key
                List<String> childNames = new ArrayList<>();
                // add the current child name to it
                childNames.add(childName);
                // and put the new key and value in the map
                results.put(parentName, childNames);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // print the results
    results.forEach((p, c) -> System.out.println(p + ": " + String.join(", ", c)));
}