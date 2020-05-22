List<String> parsedNumbers = IntStream.range(1, 6)
    .mapToObj(String::valueOf)
    .map(integerAsString -> {
        System.out.println("First print statement: " + integerAsString);
        return integerAsString;
    })
    .map(integerAsString -> {
        System.out.println("Second print statement: " + integerAsString);
        return integerAsString;
    })
    .collect(Collectors.toList());