List<A> consignments = 
    IntStream.range(0, days)
             .mapToObj(startDate::plusDays)
             .flatMap(day -> IntStream.range(0, hours)
                                      .mapToObj(hour -> myFunction()))
             .collect(toList());