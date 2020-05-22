Map<Owner, List<Cat>> byOwner = catList.stream()
        .collect(Collectors.groupingBy(Cat::getOwner));
// {Owner(name=John)=[Cat(name=Cat1), Cat(name=Cat3)], Owner(name=Scott)=[Cat(name=Cat4)], Owner(name=Smith)=[Cat(name=Cat2)]}

Map<String, List<Cat>> byColor = catList.stream()
        .collect(Collectors.groupingBy(Cat::getColor));
// {Brown=[Cat(name=Cat1), Cat(name=Cat3)], White=[Cat(name=Cat4)], Black=[Cat(name=Cat2)]}