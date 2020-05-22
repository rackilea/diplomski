interface WithJson {
    void setJson(JSONObject jo);
}

public class Data<T extends WithJson> {
    public Data(String response1, Class<T> type) {
        data = new ArrayList<T>();
        JSONArray ja;
        try {
             ja = new JSONArray(response1);
             for (int i = 0; i < ja.length(); i++) {
                 JSONObject jo = (JSONObject) ja.get(i);
                 T obj = type.newInstance();
                 object.setJson(jo);
                 data.add(obj);
             }
        } catch (JSONException e) {
             e.printStackTrace();
        }
    }
}