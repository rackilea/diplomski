private static void printArray(int [][] array){
    if(array == null || array.length < 1 || array[0].length < 1)
        throw new IllegalArgumentException("array must be non-null, and must have a size of at least \"new int[1][1]\"");
    for (int i = 0; i < array.length; i++) {
        for(int j = 0; j < array[0].length; j++)
            System.out.print("[" + array[i][j] + "]");
        System.out.println();
    }
}