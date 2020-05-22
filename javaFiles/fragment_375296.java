public static void main(String[] args) throws IOException, ParseException{
    FileReader reader = new FileReader(new File("filename.json"));


    JSONParser jsonParser = new JSONParser();
    JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
    JSONObject object = (JSONObject) jsonArray.get(0);
    long elementaryProductId = (Long) object.get("elementaryProductId");



    System.out.println("The id is: " + elementaryProductId);
}