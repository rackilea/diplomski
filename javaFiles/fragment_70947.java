list.stream().collect(Collectors.groupingBy(Foo::getCategory))
    .entrySet().stream()
    .collect(Collectors.toMap(x -> {
        int sumAmount = x.getValue().stream().mapToInt(Foo::getAmount).sum();
        int sumPrice= x.getValue().stream().mapToInt(Foo::getPrice).sum();
        return new Foo(x.getKey(), sumAmount, sumPrice);
    }, Map.Entry::getValue));