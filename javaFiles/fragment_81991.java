Predicate<A> predicate = methodAWithPredicate(someArg);
if (x > 0)
    predicate = predicate.and(methodBWithPredicate(someArg));
predicate = predicate.and(methodCWithPredicate(someArg));

listOfA.stream()
    .filter(predicate)
    .collect(Collectors.toList());