JSONParser parser = new JSONParser();
Object obj = parser.parse(new FileReader("...")); //the location of the file
JSONObject jsonObject = (JSONObject) obj;
JSONArray numbers = (JSONArray) jsonObject.get("numbers");

for (Object number : numbers) {
    JSONObject jsonNumber = (JSONObject) number;
    String natural = (String) jsonNumber.get("natural");
    System.out.println(natural);
}