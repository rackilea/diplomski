// initialized stream of optional
Stream<Optional<Integer>> so = Stream.empty(); 

// mapped stream of T 
Stream<Integer> s = so.flatMap(Optional::stream);   

// constructing optional from the stream
Optional<Stream<Integer>> os = Optional.of(s);