int currentMaxLength = Integer.MIN_VALUE;
for (int i = 0; i < sums.length; i++) { 
   int k = S-sums[i];
   List<Integer> l = map.get(k);
   if (l == null) continue;
   int width = Math.abs(l.getLast() -  i);
   if (width > currentMaxLength) currentMaxLength = width;
}
return currentMaxLength;