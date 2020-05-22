static <T> List<List<T>> listSplitter(List<T> incoming, int size) {
    // add validation if needed
    return incoming.stream()
            .collect(Collector.of(
                    ArrayList::new,
                    (accumulator, item) -> {
                        if(accumulator.isEmpty()) {
                            accumulator.add(new ArrayList<>(singletonList(item)));
                        } else {
                            List<T> last = accumulator.get(accumulator.size() - 1);
                            if(last.size() == size) {
                                accumulator.add(new ArrayList<>(singletonList(item)));
                            } else {
                                last.add(item);
                            }
                        }
                    },
                    (li1, li2) -> {
                        li1.addAll(li2);
                        return li1;
                    }
            ));
}
System.out.println(
        listSplitter(
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                4
        )
);