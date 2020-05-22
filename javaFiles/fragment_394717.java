List<Competitor> minListCompetitor = anotherListOfListCompetitor.stream()
        .min(Comparator.comparingInt(l -> l.stream().mapToInt(Competitor::getPower).sum()))
        .orElse(Collections.emptyList());

List<Competitor> maxListCompetitor = anotherListOfListCompetitor.stream()
        .max(Comparator.comparingInt(l -> l.stream().mapToInt(Competitor::getPower).sum()))
        .orElse(Collections.emptyList());