sortOrderCache = myThings.stream()
                         .collect(Collectors.groupingBy(
                           Thing::getId, Thing::getSortOrder);
codeNameCache= myThings.stream()
                       .collect(Collectors.groupingBy(
                         Thing::getId, Thing::getCodeName);