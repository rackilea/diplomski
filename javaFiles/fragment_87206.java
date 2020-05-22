double average = Pattern.compile("\\b\\d+\\b")
        .matcher(a)
        .results()
        .map(MatchResult::group)
        .mapToInt(Integer::valueOf)
        .average()
        .orElse(0);