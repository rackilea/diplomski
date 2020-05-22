List<Double> list1 = List.of(1D, 1.5D);
List<Double> list2 = List.of(30D, 25D);
List<Double> list3 = List.of(30D, 25D);
Stream<List<Double>> listStream = Stream.of(list1, list2, list3);

int maxSize = listStream.mapToInt(List::size).max().orElse(0);

IntStream.range(0, maxSize)
        .forEach(index -> {
            listStream
                    .filter(list -> list.size() > index)
                    .forEach(list -> System.out.print(list.get(index) + " "));
            System.out.println();
        });