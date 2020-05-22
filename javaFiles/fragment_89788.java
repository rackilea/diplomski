Random random = new Random();
Player[] subset = random.ints(0, allPlayers.length)
                        .distinct()
                        .limit(subsetSize)
                        .mapToObj(i -> allPlayers[i])
                        .toArray(Player[]::new);