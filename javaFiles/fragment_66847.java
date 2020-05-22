LinkedHashMap<String, List<String>> tradeDetailsNewOrPrevious = new LinkedHashMap<>();

  //    taking some values for a clear understanding
  tradeDetailsNewOrPrevious.put("AA", Arrays.asList("a", "aa", "aaa"));
  tradeDetailsNewOrPrevious.put("BB", Arrays.asList("b", "bb", "bbb"));
  tradeDetailsNewOrPrevious.put("CC", Arrays.asList("c", "cc", "ccc"));

  LinkedHashMap<String, List<String>> temp = new LinkedHashMap<String, List<String>>();

  List<String> tradeIDs = Arrays.asList("AA", "CC", "DD");

  for (String tradeID : tradeIDs)
  {
     if (tradeDetailsNewOrPrevious.keySet().contains(tradeID))
     {
        temp.put(tradeID, tradeDetailsNewOrPrevious.get(tradeID));
     }
  }