List<Output> output = Stream.of(Stream.of(new Node(1), new Node(2)), Stream.of(new Node(2)))
            .flatMap(x -> x)
            .collect(Collectors.collectingAndThen(
                    Collectors.groupingBy(
                            Node::getNodeId,
                            Collectors.summingInt(n -> 1)),
                    map -> map.entrySet()
                            .stream()
                            .map(e -> new Output(e.getKey(), e.getValue()))
                            .collect(Collectors.toList())));

    System.out.println(output); // [id = 1 count = 1, id = 2 count = 2]