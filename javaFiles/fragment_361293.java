void reduce() {
    HashMap<xxx, Integer> reducer1 = new HashMap<xxx, Integer>();
    for (int i=0; i< m1.size(); i++) {
        xxx key = m1.get(i).getKey();

        int count = 0;
        if ( reducer1.containsKey(key) ) count = reducer1.get(key);

        reducer1.put(key, count+1);  
     }
     //print the values
}