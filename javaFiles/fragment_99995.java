public void heapsAlgorithm(int size, int[] array, List<int[]> result) {
    if (size == 1){
        result.add(array.clone());
        //System.out.println(Arrays.toString(array)); // here I want to add this array to a list
    } else {
        for (int i = 0; i < array.length; i++) {
            heapsAlgorithm(size - 1, array, result);
            if(size%2==0 ){
                swap(array[i], array[size-1]);
            } else {
                swap(array[0], array[size-1]);
            }
        }
    }
}