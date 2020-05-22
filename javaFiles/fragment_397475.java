public static int[] numEven(int[] array) {
    List<Integer> evenNumbers = new ArrayList<>();

    for(int i=0;i<array.length;i++){
        if(array[i] % 2 == 0){
            evenNumbers.add(array[i]);
        }
    }

    int[] result = new int[evenNumbers.size()];
    for (int i = 0; i < evenNumbers.size(); i++) {
        result[i] = evenNumbers.get(i);
    }

    return result;
}