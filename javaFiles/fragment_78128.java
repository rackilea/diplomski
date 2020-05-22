Map<String, Integer> aggResult = new HashMap<>();
while (rs.next()) {
    String name = rs.getString(NAME_INDEX); //NAME_INDEX - name column index
    int value = rs.getInt(VALUE_INDEX); //VALUE_INDEX - value column index

    aggResult.merge(name, value, Integer::sum);

    //if you dont have java8 use this "if":
    /*
    if (aggResult.containsKey(name)) {
        Integer sum = aggResult.get(name);
        aggResult.put(name, sum + value);
    } else {
        aggResult.put(name, value);
    }
    */
}
//test output:
aggResult.forEach((key, value) -> System.out.println(key + ": " + value));