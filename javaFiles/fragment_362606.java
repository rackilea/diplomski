Map<Integer,Integer> histogram = new HashMap<>();
for (int x : arr) { 
  if (!histogram.containsKey(x)) histogram.put(x,1); 
  else histogram.put(x,histogram.get(x) + 1);
}
int max = 0;
for (int x : histogram.values) max = max > x ? max : x;
return max;