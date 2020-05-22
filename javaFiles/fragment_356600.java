TreeMap<Integer, TreeSet<Integer>> map;
TreeSet<Integer> set = map.get(group);
if (set == null) // create it if it doesn't exist
{
  set = new TreeSet<Integer>();
  map.put(group, set);
}
set.add(child);