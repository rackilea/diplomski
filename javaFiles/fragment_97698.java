Set<String> bDeps = workCenters.stream()
                               .map(B::getDepartment)
                               .collect(Collectors.toSet());

List<A> collect = skills.stream()
                         .filter(s -> bDeps.contains(s.getDepartment()))
                         .collect(Collectors.toList());