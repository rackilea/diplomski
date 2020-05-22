for (Integer i : list2) {
  if (!list1.contains(i)) 
    tmp.add(i);
} 
-> list2 iteration => N2
-> for each of this iteration, you call .contain method 
   which uses sequential search, resulting in N1/2 iterations (on average)
-> So, you get N2*N1/2