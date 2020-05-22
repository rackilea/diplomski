Optional<Integer> optionalInt = getSomeOptionalInt();
Number value = optionalInt.or(0.5); // error

FluentIterable<? extends Number> numbers = getSomeNumbers();   
Optional<? extends Number> first = numbers.first();
Number value = first.or(0.5); // error