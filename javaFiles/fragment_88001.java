Player lowestPlayer = lowestTrump.entrySet()
        .stream()
        .min(Comparator.comparingInt(Map.Entry::getValue))
        .map(Map.Entry::getKey)
        .orElse(null);

String attackerFound = lowestPlayer != null ? lowestPlayer.getName() : null;