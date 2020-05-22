// generate a list of values between min and max
generated = IntStream.rangeClosed(min, max)
        .map(String::valueOf)
        .collect(Collectors.toCollection(ArrayList::new));

// shuffle them
Collections.shuffle(generated);