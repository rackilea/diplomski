List<Number> numbers = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
sort1(numbers);    // Valid: Number extends Number
sort1(integers);   // Valid: Integer extends Number
sort2(numbers);    // Valid: Type matches exactly
sort2(integers);   // Invalid: integers is not an instance of List<Number>