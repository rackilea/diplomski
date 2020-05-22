Map<Integer,List<Integer>> map = new HashMap<>();
for (int i = 0; i < sums.length; i++) {
   List<Integer> l = map.get(sums[i]);
   if (l == null) { 
       l = new ArrayList<>();
       map.put(sums[i],l);
   }
   l.add(i);
}