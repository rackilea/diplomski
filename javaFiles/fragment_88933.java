public static int[] sum(int[] array) {
  int[] newArray = new int[array.length];

  for (int i = 0; i < array.length; i++) {
    newArray[i] = array[i];
    if (i > 0) {
      newArray[i] += newArray[i-1];
    }
  }

  return newArray;
}