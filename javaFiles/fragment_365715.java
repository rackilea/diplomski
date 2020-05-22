int size = points.size();
 IntStream.range(0, size)
            .boxed()
            .flatMap(i -> IntStream.range(i + 1, size)
                                   .mapToObj(j -> new Line2D.Double(points.get(i), points.get(j))))
            .collect(Collectors.toList());