List<Pair<SomeObject, Integer>> process(List<SomeObject> input) {
   List<Pair<SomeObject, Integer>> result = new ArrayList<>();
   Map<Integer, Pair<SomeObject, Integer>> map = new HashMap();
   List<SomeObject> couldBeProcessed = new ArrayList<>();

   for (int i = 0; i < input.size(); i++) {
      if (couldBeProcessed(input.get(i))) {
         couldBeProcessed.add(obj);
      } else {
         map.put(i, Pair.newInstance(obj, 0));
      }
   }

   List<Pair<SomeObject, Integer>> processResult = processInBatch(couldBeProcessed); 

   for (int i = 0; i < input.size(); i++) {
      if (map.containsKey(i)) {
         result.add(map.get(i));
      } else {
         result.add(processResult.remove(0));
      }
   }
}