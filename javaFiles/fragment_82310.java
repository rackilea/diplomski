public class Test {

    private static JSONObject processString(String data, int level) throws JSONException {
        JSONObject json = new JSONObject();
        int index = data.indexOf(',');
        String name = data;
        String remainder = "";
        if (index < 0) {
            index = name.indexOf('(');
            if (index > 0) {
                name = data.substring(0, index);
            }
        } else {
            name = data.substring(0, index);
            remainder = data.substring(name.length() + 1);
        }
        json.put("name", name);

        JSONArray a = new JSONArray();
        if (remainder.length() > 0) {
            a.put(processString(remainder, level + 1));
            json.put("T" + level, a);
        } else {
            json.put("leaf", a);
        }
        return json;
    }  

    private static JSONArray processList(List<String> list, int level) throws JSONException {
        JSONArray json = new JSONArray();
        for (String data : list) {
            json.put(processString(data, level));
        }
        return json;
    }  

    private static JSONObject processMap(Map<String>, List<String>> map, int level) throws JSONException {
        JSONObject json = new JSONObject();
        for (String key : map.keySet()) {
            json.put("name", key);
            json.put("T" + level, processList(map.get(key), level + 1));
        }
        return json;
    }        

    public static void main(String args[]) {
        Map<String, List<String>> consilatedMapMap = new LinkedHashMap<String, List<String>>();
        List<String> values = new LinkedList<String>();
        values.add("Cone,KoolCool(21)");
        values.add("Stick,KoolCool(25)");
        consilatedMapMap.put("Ice creams", values);

        try {
            int level = 2;
            JSONObject json = processMap(consilatedMapMap, level);
        } catch(JSONException x) {
            x.printStackTrace();
            System.exit(-1);
        }
}