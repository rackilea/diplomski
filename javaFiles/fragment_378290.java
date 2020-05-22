public List<Player> getPlayers(Team team, int age) {
    return Optional.ofNullable(team).map(Team::getPlayers)
            .orElse(Collections.emptyList())
            .stream()
            .filter(a -> Integer.parseInt(a.getAge()) > 20)
            .collect(Collectors.toList());
}