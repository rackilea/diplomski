aList.stream()
    .map(applyIfNotNull(A::getB))
    .map(applyIfNotNull(B::getC))
    .map(applyIfNotNull(C::getD))
    .map(applyIfNotNullOrDefault(D::getValue, "default"))
    .filter(Objects::nonNull)
    .forEach(System.out::println);