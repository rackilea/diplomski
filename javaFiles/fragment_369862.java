Function<Game, Boolean> isFinished = game -> "FINISHED".equals(game.battleStatus);

Map<String, Map<Boolean, Long>> groupedGames = 
    games.stream()
         .collect(groupingBy(Game::getUserId, 
                      groupingBy(isFinished, counting())));