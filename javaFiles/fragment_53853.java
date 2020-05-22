Optional<Number> optionalInt = (Optional) getSomeOptionalInt();   
Number value = optionalInt.or(0.5); // fine

FluentIterable<? extends Number> numbers = getSomeNumbers();   
Optional<Number> first = (Optional) numbers.first();
Number value = first.or(0.5); // fine