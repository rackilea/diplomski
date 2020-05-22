public static double calcWeightedAvg(ArrayList<Double> inputValues){
   //Get and remove weight.
   Double weight = inputValues.get(0);
   inputValues.remove(0);

   //Sum and find min.
   double min = Double.MAX_VALUE;
   double sum = 0;
   for (Double d : inputValues) {
       if (d < min) min = d;
       sum += d;
   }
   // Calculate weighted average. 
   double returnVal = (sum-min)/(inputValues.size()-1) * weight;
   // add weight back to list
   inputValues.add(0,weight);

   return returnVal;
}