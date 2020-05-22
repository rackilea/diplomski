getNames(
    strings -> {
        strings.forEach(System.out::println);
        return Unit.INSTANCE;
    }
);