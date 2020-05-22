public List<String> findLimits(List<Bet> bets) {
    return bets.stream()
            .collect(Collectors.toMap(
                    b -> b.getCustId() + LocalDate.ofInstant(b.getTimestamp(), ZoneOffset.UTC).toString(),
                    Bet::getAmount,
                    (o1, o2) -> o1 + o2))
            .entrySet().stream()
            .filter(e -> e.getValue() > 100.0)
            .map(e -> e.getKey().substring(0, e.getKey().length() - LocalDate.EPOCH.toString().length()))
            .collect(Collectors.toList());
}