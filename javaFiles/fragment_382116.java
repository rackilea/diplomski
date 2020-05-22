Map<String, String> finalResp = 
    map1.entrySet().stream().filter(e -> map2.containsKey(e.getKey()))
                            .collect(Collectors.toMap(
                                Entry::getKey, 
                                e -> changetoAnother(e.getValue(), map2.get(e.getKey()))
                            ));