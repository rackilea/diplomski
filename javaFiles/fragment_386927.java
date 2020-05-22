@DataProvider(name="provideData")
public static Object[][] getData() {
    Map<String, List<String>> map = new HashMap<>();
    map.put("Test[]", Arrays.asList("First Value", "Second Value", "Third Value", "Fourth Value"));
    map.put("month_start", Arrays.asList("2019-06-01"));
    map.put("month_end", Arrays.asList("2019-06-30"));
    map.put("viewers[]", Arrays.asList("ESPN"));
    map.put("Result[]", Arrays.asList("Fifth Value", "Sixth Value", "Seventh Value"));
    return new Object[][]{{map}};
}