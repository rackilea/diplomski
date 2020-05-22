public static List<String> getResult(String mycondition) {
    List<String> results = new ArrayList<String>();
    //using the new runSelect method
    ResultSet rsData = sql.runSelect(
        "select col1 from my_table where con=?", mycondition);
    while (rsData.next()) {
        results.add(rsData.getString("col1"));
    }
    return results;
}