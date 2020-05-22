//Test for https://stackoverflow.com/questions/27324315/
  public static void testStackO_Q_27324315() {

    Map<String, List<String>> facetsInCategories = new LinkedHashMap<String, List<String>>();
    String[] values = new String[]{"Test1", "Test2", "Test3"};
    List<String> valuesList = new ArrayList<String>(Arrays.asList(values));
    facetsInCategories.put("Test", valuesList);

    Map temp = Collections.unmodifiableMap(facetsInCategories);
    LinkedHashMap<String, List<String>> facetsInCategoriesCopy = (LinkedHashMap<String, List<String>>)deepCopy(temp);

    String facets = "test_me";

    if (!facets.equals("something")) {
        for (List<String> value : facetsInCategoriesCopy.values()) {
            if (value.size() > 1) {
                int nbrOfElements = value.size();
                for (int i = nbrOfElements-1; i > 0; i--) {
                    value.remove(i);
                }
            }
        }
    }

    System.out.println(facetsInCategories);
    System.out.println(facetsInCategoriesCopy);
}

public static <K1, K2, V> Map<K1, List<V>> deepCopy(
      Map<K1, List<V>> original){

      Map<K1, List<V>> copy = new LinkedHashMap<K1, List<V>>();
      for(Map.Entry<K1, List<V>> entry : original.entrySet()){
          copy.put(entry.getKey(), new ArrayList<V>(entry.getValue()));
      }
      return copy;
  }