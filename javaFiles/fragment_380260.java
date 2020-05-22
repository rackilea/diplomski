enum Keys {
    DATE_FIED,
    DATE_VALUE,
    LIMIT;
}
public static void main(String[] args) {

    Map<Keys, String> map = new EnumMap<>(Keys.class);
    map.put(Keys.DATE_FIED, "created_date");
    map.put(Keys.DATE_VALUE, "2004-12-05");
    map.put(Keys.LIMIT, "225");     
    String query = getValue(map);
}

private static String getValue(Map<Keys, String> map) {

    return "select * from testing where " 
                + map.get(Keys.DATE_FIED) 
                + " between " 
                + map.get(Keys.DATE_VALUE) 
                + " and date(now()) ORDER BY attributes DESC limit " 
                + Integer.parseInt(map.get(Keys.LIMIT)) + " ";


}