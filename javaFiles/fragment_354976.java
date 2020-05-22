String st = "{\"server_response\":[{\"name\":\"1\",\"email\":\"istiyak.pro@gmail.com\",\"mobile\":\"990-100010000\"},{\"name\":\"2\",\"email\":\"Tanim Khan \",\"mobile\":\"tanim@gmail.com \"},{\"name\":\"3\",\"email\":\"Rezaul Hasan \",\"mobile\":\"rezaul@gmail.com \"}]}";
JSONParser parser = new JSONParser();
try {
    Object o = parser.parse(st);
    JSONObject obj = (JSONObject) o;
    System.out.println(obj); // {"server_response":[{"name":"1","mobile":"990-100010000","email":"istiyak.pro@gmail.com"},{"name":"2","mobile":"tanim@gmail.com ","email":"Tanim Khan "},{"name":"3","mobile":"rezaul@gmail.com ","email":"Rezaul Hasan "}]}

    JSONArray arr = (JSONArray) obj.get("server_response");

    List<String> email = new ArrayList<String>();
    List<String> mobile = new ArrayList<String>();

    for (Object each: arr) {
        JSONObject a = (JSONObject) each;
        email.add(a.get("email").toString().trim());
        mobile.add(a.get("mobile").toString().trim());
    }

    System.out.println(email); // [istiyak.pro@gmail.com, Tanim Khan, Rezaul Hasan]
    System.out.println(mobile); // [990-100010000, tanim@gmail.com, rezaul@gmail.com]

} catch (org.json.simple.parser.ParseException e) {
    e.printStackTrace();
}