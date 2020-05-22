public LinkedHashMap<Integer,Integer> sortHashMapByValues(HashMap<Integer,Integer> passedMap) {
   List<Integer> mapKeys = new ArrayList<Integer>(passedMap.keySet());
   List<Integer> mapValues = new ArrayList<Integer>(passedMap.values());
   Collections.sort(mapValues);
   Collections.sort(mapKeys);

   LinkedHashMap<Integer,Integer> sortedMap = 
       new LinkedHashMap<Integer,Integer>();

   Iterator valueIt = mapValues.iterator();
   while (valueIt.hasNext()) {
       Object val = valueIt.next();
    Iterator keyIt = mapKeys.iterator();

    while (keyIt.hasNext()) {
        int key = (Integer)keyIt.next();
        int comp1 = (Integer)passedMap.get(key);
        int comp2 = (Integer)val;

        if (comp1 == comp2){
            passedMap.remove(key);
            mapKeys.remove(key);
            sortedMap.put(key,(Integer) val);
            break;
        }

    }

}
return sortedMap;
}