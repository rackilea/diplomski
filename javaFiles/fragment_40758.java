Either<String, Double> containsString = Either.<String, Double>left("first");
Either<String, Double> containsDouble = Either.<String, Double>right(2d);

their.expectsString(containsString.whichever());
their.expectsDouble(containsDouble.whichever());
their.expectsDouble(containsString.whichever());