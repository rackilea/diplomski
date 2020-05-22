// Intializing an array of length 3
int[] array = new int[] {45, 32, 75};
// Copying array with newlength as 5
array = Arrays.copyOf(array, 5);
array[3] = 11;
array[4] = 55;