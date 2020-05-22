List<String> nodesWithMoreThan100Sites = maintWindowArray.stream()
        .collect(Collectors.groupingBy(MaintWindowClass::getNode, Collectors.counting()))
        .entrySet().stream()
        .filter(e -> e.getValue() > 100)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());