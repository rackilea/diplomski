Map<Character, Integer> result = IntStream.rangeClosed('A', 'Z')
    .collect(
        HashMap::new,
        (map, c) -> map.put((char) c, c + (1 - 'A')),
        HashMap::putAll
    );