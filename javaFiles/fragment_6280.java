Collection<Integer> sortPartially(int[] inputArray, int sortedPartLength) {
    Queue<Integer> pq = new PriorityQueue<>(sortedPartLength);

    Deque<Integer> result = IntStream.of(inputArray).boxed().map(x -> {
        pq.add(x);
        return pq.size() > sortedPartLength ? pq.poll() : null;
    }).filter(Objects::nonNull).collect(Collectors.toCollection(ArrayDeque::new));

    Stream.generate(pq::remove).limit(sortedPartLength).forEach(result::addFirst);

    return result;
}