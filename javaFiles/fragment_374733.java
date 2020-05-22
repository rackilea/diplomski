List<Map<String, Object>> response = List.of(
        new HashMap<>(Map.of("productId", 1, "price", 2, "noOfBuyers", 6)),
        new HashMap<>(Map.of("productId", 2, "price", 5, "noOfBuyers", 8)),
        new HashMap<>(Map.of("productId", 1, "rating", 5)));
System.out.println(response);

Map<String, Map<String, Object>> converted = convertResponse(response);
System.out.println(converted);