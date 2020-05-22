Map<String, Integer> wordsMap = new HashMap<String,Double>();

/* Fill the wordsMap with data, then use this function to sort.
  Fill and update value by key is simple:

  wordsMap .put(key, 50); <-- put value
  wordsMap .put(key, map.get(key) + 1); <--- update value

  For example:

  wordsMap .put("google", 0); <-- put value
  wordsMap .put("google", map.get("google") + 1); <--- increment value by 1

*/

public static <K, V extends Comparable<? super V>> Map<K, V> 
    sortByValue( Map<K, V> map )
{
    List<Map.Entry<K, V>> list =
        new LinkedList<>( map.entrySet() );
    Collections.sort( list, new Comparator<Map.Entry<K, V>>()
    {
        @Override
        public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
        {
            return (o1.getValue()).compareTo( o2.getValue() );
        }
    } );

    Map<K, V> result = new LinkedHashMap<>();
    for (Map.Entry<K, V> entry : list)
    {
        result.put( entry.getKey(), entry.getValue() );
    }
    return result;
}

// sortByValue(wordsMap);