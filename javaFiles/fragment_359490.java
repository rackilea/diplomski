Map<String, AddressWrapper> result = addressList.stream()
                .collect(Collectors.groupingBy(Address::getStreetName))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> {
                    AddressWrapper addressWrapper = new AddressWrapper();
                    addressWrapper.setStreetName(e.getKey());
                    addressWrapper.setAddressWrapperList(e.getValue());
                    return addressWrapper;
                }));