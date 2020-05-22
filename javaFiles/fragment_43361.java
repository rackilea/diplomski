public static double variance(ArrayList<Integer> list) {
   double sumDiffsSquared = 0.0;
   double avg = average(list);
   for (int value : list)
   {
       double diff = value - avg;
       diff *= diff;
       sumDiffsSquared += diff;
   }
   return sumDiffsSquared  / (list.size()-1);
}