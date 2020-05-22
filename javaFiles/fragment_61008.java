Map<LocalDate, Map<String, Long>> result = myProductList.stream()
    .collect(Collectors.groupingBy(
        Product::getDate,
        TreeMap::new, // orders entries by key, i.e. by date
        Collectors.collectingAndThen(
            Collectors.groupingBy(
                Product::getProductName,
                LinkedHashMap::new,     // LinkedHashMap is mutable and 
                Collectors.counting()), // preserves insertion order, i.e.
            map -> {                    // we can insert the total later
                map.put("Total", map.values().stream().mapToLong(c -> c).sum());
                return map;
            })));