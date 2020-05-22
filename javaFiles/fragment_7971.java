public void parseJsonData(String jsonString) throws JSONException {
    String data = "";
    StringBuilder data2 = new StringBuilder();
    List<String> list = new ArrayList<>();
    JSONObject json = new JSONObject(jsonString);
    JSONArray arrayData = json.getJSONArray("data");
    for (int i = 0; i < arrayData.length(); i++) {
        JSONObject jsonDataArray = arrayData.getJSONObject(i);
        String ean = jsonDataArray.getString("ean");
        String itemname = jsonDataArray.getString("itemname");
        String locations = jsonDataArray.getString("location");
        data = "\n EAN                 = " + ean +
                "\n Item Name     = " + itemname + "\n";
        JSONArray arrayPO = jsonDataArray.getJSONArray("po");
        for (int j = 0; j < arrayPO.length(); j++) {
            JSONObject jsonPO = arrayPO.getJSONObject(j);
            ponumb = jsonPO.getString("ponumber");
            qty = jsonPO.getString("qty");
            //int numb = i + 1;
            data2.append("\n      PO Number       : " + ponumb +
                    "\n      Quantity        : " + qty + "\n");
            list.add(data + data2);
        }
        System.err.println(data + data2);
        int sb_length = data2.length();
        data2.delete(0, sb_length);
    }
}