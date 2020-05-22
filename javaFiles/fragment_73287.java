public static void main(String[] args) throws ParseException, JsonSyntaxException, IOException {
    Type type = new TypeToken<HashMap<String, Object>>() {
    }.getType();
    Gson gson = new Gson();
    HashMap<String, Object> map = gson.fromJson("your_json_string", type);
    for (String key : map.keySet()) {
        Object obj = map.get(key);
        if (obj instanceof List) {
            for (Object o : (List) obj) {
                if (o instanceof Map) {
                    loop((Map) o);
                } else {
                    System.out.println(key + " : " + o);
                }
            }
        } else if (obj instanceof Map) {
            loop((Map) obj);
        } else {
            System.out.println(key + " : " + obj);
        }
    }
}

private static void loop(Map<String, Object> map) {
    for (String key : map.keySet()) {
        Object obj = map.get(key);
        if (obj instanceof List) {
            for (Object o : (List) obj) {
                if (o instanceof Map) {
                    loop((Map) o);
                } else {
                    System.out.println(key + " : " + o);
                }
            }
        } else if (obj instanceof Map) {
            loop((Map) obj);
        } else {
            System.out.println(key + " : " + obj);
        }
    }
}