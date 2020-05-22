List<String> actualValues =  logged.stream().flatMap(l -> l.items.stream())
        .map(i -> i.value).collect(Collectors.toList());
List<String> shouldValues = should.stream().flatMap(l -> l.items.stream())
        .map(i -> i.value).collect(Collectors.toList());

boolean logMatch = actualValues.equals(shouldValues);