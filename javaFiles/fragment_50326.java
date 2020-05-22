for (int rows = 0; rows < numbers.length; rows++){
   String[] split = input.nextLine().split("\\s+"); // \\s+ is 1 or more whitespace characters
   if (split.length != numbers.length) {
      throw new IllegalArgumentException("Line " + rows + " has " + split.length + " columns, but needs " + numbers.length);
   }
   for (int columns = 0; columns < numbers[rows].length; columns++){
      numbers[rows][columns] = Double.parseDouble(split[columns]);
   }
}