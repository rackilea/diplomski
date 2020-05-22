private void m1(List<Integer> array1, List<Integer> array2, int range) {

    Integer[] rangeArray = new Integer[range];

    //Iterate first array

    for(int i = 0; i < array1.size(); i++) {

        Integer x = array1.get(i);

        rangeArray[i%range] = x;

        //Update second array

        if(i < range - 1) {
            array2.add(null);
        }
        else {
            int max = Collections.max(Arrays.asList(rangeArray));
            array2.add(max);
        }
    }
}