privat Long[] pseudoOneStepConversion(String[] numbers) {
  Long[] result = new long[numbers.length];
  for (int i = 0; i < numbers.length; i++)
     result[i] = Long.parseLong(numbers[i]);
  return result;
}