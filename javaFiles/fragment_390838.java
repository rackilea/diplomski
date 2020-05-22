ResultSet rs = DB.doQuery("SELECT username,register_ip FROM users ORDER BY joined DESC LIMIT 10");
List<Map<String , String>> myMap  = new ArrayList<Map<String,String>>();
int c = 0;

while(rs.next()) {
    //Create a new instance of the map
    Map<String,String> botInfo = new HashMap<String, String>();

    //Add elements to the the map
    botInfo.put("username", rs.getString("username"));
    botInfo.put("register_ip", rs.getString("register_ip"));

    //Add the map to the list
    myMap.add(c, botInfo);

    //Increment your counter
    c++;
}