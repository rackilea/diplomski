Map<String, ArrayList<String>> getReversedMap(Map<String, ArrayList<String>> myMap){
      Map<String, ArrayList<String>> result = new HashMap<>();
      for(String key : myMap.keySet()){
          for(String val : myMap.get(key)){
              if(!result.containsKey(val)){
                  result.put(val, new ArrayList());
              }
              result.get(val).add(key);
          }
      }
      return result;
}