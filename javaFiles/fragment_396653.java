List<Pair<String, String>> filedList = new ArrayList<>();
JSONObject jsonObject = new JSONObject(result);
try {
    String status = jsonObject.getString("STATUS");
    filedList.add(new Pair<String, String>("STATUS", status));
} catch (JSONException e) {
    e.printStackTrace();
}