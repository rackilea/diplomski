IntStream.iterate(0, player -> (player + 1) % playerCount)
             .map(PigDice::turn)
             .filter(player -> player > -1)
             .findFirst()
             .ifPresent(
                player ->
                    System.out.printf("\n\nPlayer %d wins with a score of %d",
                        player, safeScore[player]));