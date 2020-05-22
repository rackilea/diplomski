long length = IntStream.iterate(nums.length - 1, i -> i >= 0, i -> i - 1)
    .dropWhile(elementsEqual)
    .limit(1)
    .flatMap(end -> IntStream.rangeClosed(0, end))
    .dropWhile(elementsEqual)
    .count();