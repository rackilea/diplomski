double[] array = new double[] {2.0, 3.0, 0.0, 1.0};

Integer[] result = new Integer[array.length];
for (int i = 0; i < result.length; i++) {
    result[i] = i;
}
Arrays.sort(result, Comparator.<Integer>comparingDouble(index -> array[index]).reversed());

System.out.println("result = " + Arrays.toString(result));
// [1, 0, 3, 2]