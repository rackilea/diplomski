Table<DateTime, String, String> yourTable = // your HashBasedTable;
    Map<DateTime, List<Map<String, String>>> groupedRows = yourTable.rowMap()
            .entrySet()
            .stream()
            .collect(Collectors.groupingBy(e -> e.getKey().minusMillis(e.getKey().getMillisOfSecond() % 100),
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList())));