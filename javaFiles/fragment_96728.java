public void validateMarks(int[] array){
    int[] array1 = new int[array.length];
    int pos = 0;
    for (int i = 0; i < array.length; i++){
        if (array[i] >= 0 && array[i] <= 100)
            array1[pos++] = array[i];
    }
    for (int i = 0; i < array.length; i++){
        System.out.println(array1[i]);
    }
}