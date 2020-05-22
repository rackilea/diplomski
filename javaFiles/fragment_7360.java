List<Double> dValues = new ArrayList<>();
  // not shown: add your double values to the dValues list
  List<Integer> iValues =  dValues.stream()
      .map(p -> p.intValue())
      .collect(Collectors.toList());
  // or the equivalent
  //  List<Integer> iValues = dValues.stream()
  //      .map(Double::intValue)
  //      .collect(Collectors.toList());