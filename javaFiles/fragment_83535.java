public static JSONArray shuffleJsonArray (JSONArray array) throws JSONException {
    // Implementing Fisher–Yates shuffle
        Random rnd = new Random();
        for (int i = array.length() - 1; i >= 0; i--)
        {
          int j = rnd.nextInt(i + 1);
          // Simple swap
          Object object = array.get(j);
          array.put(j, array.get(i));
          array.put(i, object);
        }
    return array;
}