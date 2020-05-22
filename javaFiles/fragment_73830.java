String jsonText = "{\"CustomerPhone\":\"0300\",\"CustomerName\":\"Saleh\",\"CustomerPassword\":\"84CYmCulToJXo5KncGwSZa81acb2vbHjZ2IgUveMyeU=\",\"Salt\":\"Q/IoQURM1Cv05wbkJjuo3w==\"}";
try {
    JSONObject jsonObj = new JSONObject(jsonText);
    String CustomerPhone = jsonObj.getString("CustomerPhone");
    String CustomerName = jsonObj.getString("CustomerName");
} catch (JSONException e){
    e.printStackTrace();
}