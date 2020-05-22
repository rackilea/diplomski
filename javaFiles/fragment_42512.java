SortedMap<String, Integer> result = groups
            .values()
            .stream()
            .filter(g -> g.getBids() != null || !g.getBids().isEmpty())
            .flatMap(g -> g.getBids().values().stream())
            .collect(Collectors.groupingBy(b -> b.getGroup().getProductType(),
                    TreeMap::new,
                    Collectors.mapping(Bid::getPrice,
                            Collectors.collectingAndThen(Collectors.maxBy(Comparator.naturalOrder()), Optional::get))));