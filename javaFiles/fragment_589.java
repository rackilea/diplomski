Map<Pair<String, String>, String> result = triplets.stream()
    .collect(
        Collectors.toMap(
            t -> new Pair(t.getOne(), t.getTwo()),
            Triple::getThree,
            (v1, v2) -> v2
        )
    );