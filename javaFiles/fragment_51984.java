String[] lookupIds = new String[] { "12345" };
    MapSqlParameterSource paramMap = new MapSqlParameterSource();
    List<String> paddedIds = Arrays.asList(lookupIds).stream()
        .map(i -> { return String.format("%1$-40s",i); })
        .collect(Collectors.toList());
    paramMap.addValue("item_ids", paddedIds, java.sql.Types.CHAR);