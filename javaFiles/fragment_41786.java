Stream.concat(StreamSupport.stream(spliterator1, false), StreamSupport.stream(spliterator2, false)).
        limit(3).
        collect(Collectors.toList());

System.out.println("spliterator1.estimateSize() = " + spliterator1.estimateSize());
System.out.println("spliterator2.estimateSize() = " + spliterator2.estimateSize());