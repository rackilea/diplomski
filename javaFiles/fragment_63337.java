static int[] secondHalf(int[] vector, boolean include) {
    int size = vector.length/2 + (include && vector.length%2 != 0 ? 1 : 0);
    int[] vector_2 = new int[size];

    for(int i = 0; i < size; i++)
        vector_2[i] = vector[vector.length - size + i];

    return vector_2;
}