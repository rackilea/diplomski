public int[] randomIntArray(int length, int size) {
  Random r = new Random();
  int[] numbers = new int[length];
  for(int i = 0; i < length; i++) {
    numbers[i] = r.nextInt(size+1);
  }
  return numbers;
}