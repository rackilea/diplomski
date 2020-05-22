public static String parse_if_update(String jsonResponse) {
String update="no";

    if (jsonResponse != null) {    
        try {
                JSONObject json = new JSONObject(jsonResponse);
                if (json != null) { 
                    update = json.getString("update");
                }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(update == null){
            update="no";
        }
    }
    return update;
}