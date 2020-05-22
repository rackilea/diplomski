final int DESIRED_ROW_LENGTH = 101;
for (int rows = 0; rows < numbers.length; rows++){
   numbers[rows] = Arrays.stream(input.nextLine().split("\\s+"))
                       .mapToDouble(Double::parseDouble).toArray();
   if (numbers[rows].length != DESIRED_ROW_LENGTH) {
      throw new IllegalArgumentException("Line " + rows + " has " + numbers[rows].length + " columns, but needs " + DESIRED_ROW_LENGTH);
   }
}