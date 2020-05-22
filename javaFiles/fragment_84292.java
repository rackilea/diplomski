public static void main(String args[]) throws JSONException {
    String str1 = "{\"strValue\":\"string\"}\n{\"intValue\":1}";
    JSONTokener t = new JSONTokener(str1);
    JSONObject o1 = (JSONObject) t.nextValue();
    JSONObject o2 = (JSONObject) t.nextValue();
    System.out.println(o1.getString("strValue"));
    System.out.println(o2.getLong("intValue"));
    System.out.println(t.more()); // Check if there's more token. can be used to process with loop.
}