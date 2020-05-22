private static synchronized String[][] map2data(Map<String, Object> map) {
String[][] msg_data = null;
    if (map != null) {
        msg_data = (String[][]) map.get("message_data");
       } 
return msg_data;
}