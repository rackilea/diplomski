List<WordStats> createStats(String text, Comparator<WordStats> sortingCriteria) {
        return createOccurrencesMap(text).values().stream()
                .map(WordStats::new)
                .sorted(sortingCriteria)
                .collect(Collectors.toList());
    }