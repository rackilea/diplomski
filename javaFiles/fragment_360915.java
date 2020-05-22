Integer[] arr = {4, 1, 4, 1, 3};
Map<Integer,Integer> integersCount = new HashMap<Integer,Integer>();

for (Integer i : arr){
    if (!integersCount.containsKey(i))
        integersCount.put(i, 1);
    else
        integersCount.put(i, integersCount.get(i) + 1);
    }