final List<String> sorted = l.stream()
        .sorted(
                Comparator.<String, String>comparing(
                        (str) -> str.substring(str.indexOf("#")))
                        .reversed())
        .collect(Collectors.toList());