Map<String, Map<String, String>> result = 
    sKey.entrySet().stream()
    .filter(detail -> items.keySet().contains(detail.getKey()) && 
            !Collections.disjoint(detail.getValue().keySet(), items.get(detail.getKey())))
    .collect(HashMap::new, 
            (m,v) -> m.put(v.getKey(), v.getValue().entrySet().stream()
                .filter(detail -> items.get(v.getKey()).contains(detail.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))), 
            HashMap::putAll);