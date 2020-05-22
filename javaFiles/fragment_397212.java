public static void main(String[] args) throws IOException, JSONException {
    String array = "{ \"test\" : [1, 2.5, 4, 5.66] }";

    Gson gson = new Gson();

    LinkedHashMap <String, double[]> obj 
      = gson.fromJson(array, new TypeToken<LinkedHashMap<String, double[]>>(){}.getType());

    for (Map.Entry<String, double[]> entry : obj.entrySet()) {
        System.out.println("Key = " + entry.getKey() + 
                           ", Value = " + Arrays.toString(entry.getValue()));
    }
}