// This is a member, meaning it's on class level.
private Map<Integer, List<Integer>> myHashMap = new HashMap<>();

// Now populate..  e.g. Key=123,  Value 23
private addValueForKey(Integer key, Integer value) {
  List<Integer> values = myHashMap.get( key );
  if (values == null) {
    values = new ArrayList<Integer>();       
  }

  values.add( value );
}