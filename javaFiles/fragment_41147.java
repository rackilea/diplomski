<S, T> T performOnIntersections(Function<S, T> function, S[][] inputArray, Dimensions...dimensions){

    Supplier<int[]> supplier = () -> new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    BiConsumer<int[], Dimensions> accumulator = (array, dim) -> {
        array[0] = dim.startX > array[0] ? dim.startX : array[0];
        array[1] = dim.startY > array[1] ? dim.startY : array[1];
        array[2] = dim.endX < array[2] ? dim.endX : array[2];
        array[3] = dim.endY < array[3] ? dim.endY : array[3];
    };
    BiConsumer<int[], int[]> combiner = (array1, array2) -> {
        array1[0] = array1[0] > array2[0] ? array1[0] : array2[0];
        array1[1] = array1[1] > array2[1] ? array1[1] : array2[1];
        array1[2] = array1[2] < array2[2] ? array1[2] : array2[2];
        array1[3] = array1[3] < array2[3] ? array1[3] : array2[3];
    };

    int[] searchDimensions = Arrays.stream(dimensions).collect(supplier, accumulator, combiner);

    return applyInBetween(inputArray, function, searchDimensions[0], searchDimensions[1], searchDimensions[2], searchDimensions[3]);
}