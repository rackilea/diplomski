public static double[] square (double [] array) {
  double[] result = new double[array.length];
  for(int i = 0; i < array.length ; i++ )
    result[i] = Math.sqrt(array[i]);

  return result;
}