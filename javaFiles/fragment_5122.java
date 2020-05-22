results.stream()
       .flatMap(res -> res.getSeries().stream())
       .flatMap(series -> series.getValues().stream())
       .collect(Collectors.toMap(
                              vals -> vals.get(1).toString(),
                              vals -> vals.get(2).toString(),
                              (vals1,vals2) -> vals2,
                              ConcurrentHashMap::new);