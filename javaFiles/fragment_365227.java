public static List<String> getResult(String mycondition) {
    List<String> results = new ArrayList<String>();
    ResultSet rsData = sql.RunSelect("select col1 from my_table where con='"
        +myCondition+"'");
    while (rsData.next()) {
        results.add(rsData.getString("col1"));
    }
    return results;
}