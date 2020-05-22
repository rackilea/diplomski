LinkedList<List<MyObject>> firstCollection = myObjects.stream()
    .flatMap(o -> o.qty < 100 ? Stream.of(o) : IntStream.range(0, (o.qty / 100 + 1))
        .mapToObj(x -> new MyObject(o.id, x < o.qty / 100 ? 100 : o.qty % 100))
    )
    .collect(
        Collector.of(
            LinkedList::new,
            (a, b) -> Optional.of(a).filter(Predicate.not(List::isEmpty))
                    .map(l -> l.getLast().stream().map(o -> o.qty).reduce(Integer::sum).get())
                    .filter(lastSum -> lastSum < 100)
                    .ifPresentOrElse(lastSum -> {
                        int maxQty = 100 - lastSum;
                        if (maxQty >= b.qty) {
                            a.getLast().add(b);
                        } else {
                            a.getLast().add(new MyObject(b.id, maxQty));
                            a.add(new ArrayList<>(List.of(new MyObject(b.id, b.qty - maxQty))));
                        }
                    }, () -> a.add(new ArrayList<>(List.of(b))))
            ,
            (a, b) -> { throw new UnsupportedOperationException();}
        )
    );
firstCollection.forEach(System.out::println);