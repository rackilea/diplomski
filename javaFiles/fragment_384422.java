concatWithPrevious(
    IntStream.range('A', 'Z')
        .mapToObj(i -> String.valueOf((char)i))
        .peek(s -> System.out.println("source stream: "+s))
)
.filter(Predicate.isEqual("EF"))
.findFirst()
.ifPresent(s -> System.out.println("result: "+s));