List<ToFilter> list = ...;

Set<String> option2Set = list.stream()
        .map(ToFilter::getOption2)
        .collect(Collectors.toSet());

List<ToFilter> filtered = list.stream()
        .filter(f -> !option2Set.contains(f.getOption1()))
        .collect(Collectors.toList());