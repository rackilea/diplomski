//calc averages
   for (Entry<Integer, double[]> entry : cached_weights.entrySet()) 
   {
        int key = entry.getKey();
        double[] value = entry.getValue();
        AVERAGED_WEIGHTS[ key - 1 ] +=  value[ key - 1 ]; 
    }