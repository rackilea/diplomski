List<Card> cards = IntStream.rangeClosed(1, 4)
    .boxed()
    .flatMap(value -> 
        IntStream.rangeClosed(1, 13)
            .mapToObj(suit -> new Card(value, suit))
    )
    .collect(Collectors.toList());