public static int[] Divisible(int[] array, int target){
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i<array.length; i++){
        if (array[i] % target == 0){
            list.add(array[i]);
        }
    }
    int[] ints = new int[list.size()];
    for (int i = 0; i < ints.length; i++) {
        ints[i] = list.get(i);
    }
    return ints;
}