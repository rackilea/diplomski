public static void main(String[] args) {
    String input = "aa=bbbb, cc=blabla1, ee=ffff, cc=blabla2, gg=hhhh, cc=blabla3";
    String[] splitValues = input.split(", ");
    Map<String,List<String>> results = new Hashtable<>();
    List<String> valueList = null;
    // iterate through each key=value adding to the results
    for (String a : splitValues) {
         // a = "aa=bbbb"  etc
         String[] keyValues = a.split("=");
         // you can check if values exist. This assumes they do.
         String key = keyValues[0];
         String value = keyValues[1];
         // if it is already in map, add to its value list
         if (results.containsKey(key)) {
            valueList = results.get(key);
            valueList.add(value);
          } else {
            valueList = new ArrayList<>();
            valueList.add(value);
            results.put(key, valueList);
          }
        }

         System.out.println("cc= values");
         valueList = results.get("cc");
         // assumes value is in results
         for (String a : valueList)
            System.out.println(a);

}