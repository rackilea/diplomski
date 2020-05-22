public int[] castRanInt(){
    List<Integer> intList = Arrays.asList(new Integer[]{ 0, 1, 2, 3 });
    Collections.shuffle(intList);

    // Convert List<Integer> to int[]
    int[] ret = new int[intList.size()];
    for(int i = 0; i < ret.length; i++) {
        ret[i] = intList.get(i);        
    }

    return ret;
}