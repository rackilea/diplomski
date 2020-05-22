Mock mock = new Mock();
mock.setStrings(Collections.emptyList());
final Set<ConstraintViolation<Mock>> violations1 = Validation.buildDefaultValidatorFactory().getValidator().validate(mock);
assertFalse(violations1.isEmpty());

mock.setStrings(Arrays.asList("A", "B", "C", "D"));
final Set<ConstraintViolation<Mock>> violations2 = Validation.buildDefaultValidatorFactory().getValidator().validate(mock);
assertFalse(violations2.isEmpty());