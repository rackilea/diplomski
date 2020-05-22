int[] array1 = {1, 2, 3, 4, 5};
int[] array2 = {6, 7, 8, 9, 10};
//make a new array and put all the stuff of the two arrays in it.
int[] combined = new int[array1.length + array2.length];
for (int i = 0 ; i < array1.length ; i++) {
    combined[i] = array1[i];
}
for (int i = 0 ; i < array1.length ; i++) {
    combined[i + array1.length] = array2[i];
}