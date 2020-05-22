Set<Entry<String, Integer>> set = map.entrySet();
List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
{
  public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
  {
    int result = (o2.getValue()).compareTo( o1.getValue() );
    if (result != 0) {
      return result;
    } else {
      return o1.getKey().compareTo(o2.getKey());
    }
  }
} );