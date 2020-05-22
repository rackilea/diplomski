int elementCount = upperBound / step;
if (upperBound % step != 0) elementCount++;

List<Integer> list = IntStream.range(0, elementCount)
         .map(i -> i * step)
         .boxed()
         .collect(toCollection(LinkedList::new));