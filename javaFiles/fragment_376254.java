Map<String, Long> bag =
    StreamEx.split("one o'clock two o'clock three o'clock rock", " ")
            .sorted()
            .runLengths()
            .reverseSorted(Map.Entry.comparingByValue())
            .toCustomMap(LinkedHashMap::new);