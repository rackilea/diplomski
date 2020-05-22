private static boolean checkMiracleN(List<Integer> l, int n){
   long sum = 0;
   for (int i=0; i<n; i++)
       sum = sum * 10 + l.get(i);
   return sum % n == 0;
}

private static boolean checkMiracle(ArrayList<Integer> l){
    for (int n=2; n<=10; n++)
       if (!checkMiracleN(l, n) 
          return false;
    return true;
}