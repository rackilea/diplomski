Map<String, AddressWrapper> result = addressList.stream()
                .collect(Collectors.groupingBy(Address::getStreetName))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, 
                              e -> new AddressWrapper(e.getKey(), e.getValue())));