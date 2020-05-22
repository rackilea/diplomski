List<String> cookies = ...;//Some data
Map<String, String> result = cookies.stream()
        .flatMap(c -> Arrays.stream(c.split(";\\s*")))
        .filter(s -> s.contains("session") || s.contains("max-age"))
        .map(s -> s.split("="))
        .collect(Collectors.toMap(s -> s[0], s -> s[1]));