double result = items.stream()
            .collect(
                    Collectors.collectingAndThen(
                            Collectors.groupingBy(
                                    Item::getGroupName,
                                    Collectors.summingDouble(Item::getValue)),
                            map -> map.values().stream().mapToDouble(Double::doubleValue).sum() / map.size()));