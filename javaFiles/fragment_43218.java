Map<Integer, String> statementParams = new HashMap<>();
String query = "select * From t_person";
boolean firstCondition = true;

if (Parameter.get(0) != null) {
    if (firstCondition) {
        query += " where ";
        firstCondition = false;
    } else {
        query += " and ";
    }
    query += "user_a = ?";
    statementParams.put(1, Parameter.get(0));
}
// other params
PreparedStatement Statement = connection.prepareStatement(query);

for (MapEntry<Integer, String> entry : statementParams.entrySet()) {
    Statement.setString(entry.getKey(), entry.getValue());
}