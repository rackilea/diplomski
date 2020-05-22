storesList.stream()
           .collect(Collectors.toMap(
                Store::getShopId,
                Function.identity(),
                BinaryOperator.minBy(Comparator.comparingLong(Store::getDistance))
              ))
           .values()
           .forEach(System.out::println);