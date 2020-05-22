Set<String> left = nonBeans.stream()
            .map(AreaOfInterest::getValue)
            .collect(Collectors.toSet());

beans.stream()
      .filter(x -> left.contains(x.getValue()))
      .forEach(x -> x.setSelected(true));