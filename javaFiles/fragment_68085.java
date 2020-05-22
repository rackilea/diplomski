JSONArray json = new JSONArray(data);
String[][] array = new String[json.length()][5];

for (int i=0; i < json.length(); i++) {                           
    JSONObject obj = json.getJSONObject(i);
    array[i][0] = String.valueOf(obj.getInt("Artikelnummer"));
    array[i][1] = String.valueOf(obj.getDouble("Preis"));
    array[i][2] = obj.getString("Von");
    array[i][3] = obj.getString("Bis");
    array[i][4] = obj.getString("art_link");
}