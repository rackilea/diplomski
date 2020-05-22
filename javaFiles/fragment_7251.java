KTable<Windowed<String>, JsonNode> aggregatedData = data.aggregate(
        () -> initialMessage,

        (key, incomingMessage, initialMessage) -> countData(incomingMessage, initialMessage),

        tmpMerger,

        SessionWindows.with(SESSION_TIMEOUT_MS),

        jsonSerde, 

        "aggregated-data");