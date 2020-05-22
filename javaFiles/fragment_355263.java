public static int[] appendToArray(int[] array, int value) {
     int[] result = Arrays.copyOf(array, array.length + 1);
     result[result.length - 1] = value;
     return result;
}
//--------------------------------------------
Int newId = kbd.nextInt();
id[] = appendToArray(id, newId);