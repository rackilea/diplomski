public double[] getTotalDistances(){
   double[] distance = new double[3];

   for(Activity activity: diary) {
      if (activity instanceof Run) {
         distance[0] += activity.getDistance(); 
      } else if (activity instanceof Cycle) {
         distance[1] += activity.getDistance();
      } else {
         distance[2] += activity.getDistance();
      }
   }
   return distance;
}