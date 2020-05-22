List<Set<String>> parts = model.getInstances().stream()
        .map(i -> i.getElements().stream()
                .map(Element::getPartNumber)
                .collect(Collectors.toSet()))
        .collect(Collectors.toList());

response.getDomains().stream()
        .filter(d -> parts.stream()
                .allMatch(p -> d.getHardwares().stream()
                        .map(Hardware::getPartNumber)
                        .anyMatch(p::contains)))
        .forEach(System.out::println);