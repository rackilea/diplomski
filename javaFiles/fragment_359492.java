Map<String, AddressWrapper> resultSet = addressList.stream()
      .collect(Collectors.toMap(Address::getStreetName,
              e -> new AddressWrapper(e.getStreetName(),
                      new ArrayList<>(Collections.singletonList(e))),
            (left, right) -> {
                left.getAddressWrapperList().addAll(right.getAddressWrapperList());
                return left;
            }));