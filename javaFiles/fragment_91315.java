List<Map<String, Object>> maps = null;

Map<Integer, List<Integer>> result = maps.stream()
        .collect(Collectors.groupingBy(
                map -> ((Number) map.get("id")).intValue(),
                    Collectors.mapping(map -> ((Number) map.get("uid")).intValue(), 
                            Collectors.toList())));