List<SomeClass> list = Stream.of(
            new SomeClass(SomeEnum.SONG),
            new SomeClass(SomeEnum.SONG),
            new SomeClass(SomeEnum.KLIP),
            new SomeClass(SomeEnum.KARAOKE),
            new SomeClass(SomeEnum.KARAOKE))
            .collect(Collectors.toList());

// this is what you are looking for
Map<SomeEnum, List<SomeClass>> map = list.stream()
        .collect(Collectors.groupingBy(SomeClass::getSomeEnum));