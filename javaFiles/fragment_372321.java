KTable<String, JsonNode> bankBalance = input
        .groupByKey(Grouped.with(Serdes.String(), jsonSerde))
        .aggregate(
                () -> initialBalance,
                (key, transaction, balance) -> newBalance(transaction, balance),
                Materialized.with(Serdes.String(), jsonSerde)
        );