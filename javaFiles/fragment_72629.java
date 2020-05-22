List<Pattern> patterns = patternList.stream().map(Pattern::compile).collect(Collectors.toList());
Map<String, String> finalMap = map.entrySet().stream()
        .filter(
                entry -> patterns.stream()
                        .anyMatch(
                                pattern -> pattern.matcher(entry.getKey()).matches()
                        )
        )
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().asText()
        ));