List<Map<String, Integer>> products = new ArrayList<>();
//Add products Maps here 

Map<String, Integer> cumulativeMap = new HashMap<String, Integer>();
// Use enhaced for loop for efficiency.
for(Map<String, Integer> productMap: products){
  for(Map.Entry<String, Integer> p: productMap.entrySet()){

   if(cumulativeMap.containsKey(p.getKey())){
      cumulativeMap.put(p.getKey(), cumulativeMap.get(p.getKey())+ p.getValue());
   }
   else{
     cumulativeMap.put(p.getKey(),  p.getValue());
   }
  }
}