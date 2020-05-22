static List<String> orderByRef(Map<String, Set<String>> relationshipMap)
{
  final Map<String, Set<String>> relationshipMapCopy = new HashMap<>();
  for(String key : relationshipMap.keySet())
    relationshipMapCopy.put(key, new HashSet<>(relationshipMap.get(key)));

  final Map<String, Set<String>> referencedBy = new HashMap<>();
  for(String key : relationshipMap.keySet())
    referencedBy.put(key, new HashSet<>());

  for (Entry<String,Set<String>> e : relationshipMapCopy.entrySet())
    for(String v : e.getValue())
      referencedBy.get(v).add(e.getKey());

  PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>()
  {
    @Override
    public int compare(String k1, String k2)
    {
      return relationshipMapCopy.get(k1).size() - relationshipMapCopy.get(k2).size();
    }
  });
  pq.addAll(relationshipMap.keySet());

  List<String> orderedKeys = new ArrayList<>();
  while(!pq.isEmpty()) 
  {      
    String minKey = pq.poll();
    if(!relationshipMapCopy.get(minKey).isEmpty()) 
    {
      // cyclic relationship
      break;
    }
    orderedKeys.add(minKey);
    for(String refKey : referencedBy.get(minKey))
    {
      // remove minKey from value set of refKey 
      relationshipMapCopy.get(refKey).remove(minKey);
      // reorder refKey in pq
      pq.remove(refKey);
      pq.add(refKey);
    }
  }

  return orderedKeys;    
}