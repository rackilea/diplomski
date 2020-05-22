try {
  JSONParser parser = new JSONParser();
  JSONObject json = (JSONObject) parser.parse(stringToParse);
} catch (org.json.simple.parser.ParseException e) {
   e.printStackTrace();
}