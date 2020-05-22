List<Car> sortedCars = cars
        .stream()
        .sorted(Comparator.comparing(
            Car::getName,
            Comparator.comparing((String x) -> x.equals("Unassigned"))
                      .thenComparing(Comparator.naturalOrder())))
        .collect(Collectors.toList());