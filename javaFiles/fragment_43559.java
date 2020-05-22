Collection<String> allowedStrings = Arrays.asList("Hello", "World"); 

AllowedValues<String> allowedValues = new AllowedValue<>(allowedStrings);

assert(allowedValues.exist("Hello"));
assert(!allowedValues.exist("Universe"));