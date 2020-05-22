Collection<String> resourceIds = Lists.newArrayList(
  Iterables.filter(
     Iterables.transform(matchingComputers, yourFunction),
     Predicates.notNull()
  )
);