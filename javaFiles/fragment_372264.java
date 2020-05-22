return Stream.of(Boolean.valueOf(b))
     .filter(Function.identity())
     .map( b -> trueResult)
     .findAny()
     .orElse( falseResult);

 ----

 return Optional.of(b)
     .filter(function.identity())
     .map( b -> trueResult)
     .orElse(falseResult);