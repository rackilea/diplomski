FunctionalSequence<BigInteger> fiboSequence =  new FunctionalSequence<>();
    fiboSequence.
        initialize(Stream.of(BigInteger.ONE,BigInteger.ONE)).
        setSequenceFunction(
            (i) ->
            fiboSequence.get(i-2).add(fiboSequence.get(i-1))
        );