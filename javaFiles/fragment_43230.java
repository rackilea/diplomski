int max = Integer.MIN_VALUE;
for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
  max = Math.max(max, entry.getValue());
}

if(n == max) {
  // do something       
}