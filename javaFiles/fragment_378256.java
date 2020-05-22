String[]  array = {"aaa2=asdas","aaa=asdasd"};

    LinkedHashMap<String, String> aaa = Arrays.stream(array)
            .map(s -> s.split("=", 2))
            .filter(s -> s.length == 2) // ignore strings that don't contain '='
            .peek(s -> { s[0] = s[0].trim(); })
            .peek(s -> { s[1] = s[1].trim(); })
            .filter(s -> s[0].length() != 0) // key should be present
            .filter(s -> s[1].length() != 0) // value should be present
            .collect(Collectors.toMap(
                    s -> s[0],
                    s -> s[1],
                    (first, second) -> second,
                    LinkedHashMap::new));