double[] finalSum = new double[N];

for ( Map.Entry<String,Double> entry : m1.entrySet() ) {
     if ( m2.containsKey(entry.getKey()) ) {
         //if the key is common in map1 and map2, compare the values
         double y=entry.getValue();
         double j[]=m2.get(entry.getKey());
         for (int u=0;u<j.length;u++){
             finalSum[u] += y * j[u];
         }
     }
}