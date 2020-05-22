JSONParser jsonParser = new JSONParser();

try {
  Object json = jsonParser.parse(jsonString);

  JSONObject jsonObject = (JSONObject) json;

  JSONArray rowsArray = (JSONArray) jsonObject.get("rows");

  for (Object aRow : rowsArray) {
    JSONObject aRowObject = (JSONObject) aRow;

    JSONArray elementArray = (JSONArray) aRowObject.get("elements");

    for (Object anElement : elementArray) {
      JSONObject distanceObj = (JSONObject) ((JSONObject) anElement).get("distance");

      String text = (String) distanceObj.get("text");
      long value = Long.valueOf((String) distanceObj.get("value"));

      System.out.println(text + " " + value);
    }
  }
} catch (ParseException e) {
  e.printStackTrace();
}