// Intializing an array of length 3
int[] array = new int[] {45, 32, 75};
// Copying array with newlength as 5
int[] biggerArray = new int[5];
System.arraycopy(array, 0, biggerArray, 0, array.length);
biggerArray [3] = 11;
biggerArray [4] = 55;