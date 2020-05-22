Stream<Character> charStream = IntStream.range(0, str.length())
                                        .mapToObj(i -> str.charAt(i));

WordCountState finalState = charStream.parallel()
        .map(ch -> new WordCountState().accumulate(ch))
        .reduce(new WordCountState(), WordCountState::combine);