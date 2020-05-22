List<List<Integer>> sublists = IntStream.of(1, 1, 1, 2, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 4, 4, 4, 6)
        .collect(ArrayList::new, (lists, value) -> {
            if (lists.isEmpty() || lists.get(lists.size() - 1).stream().noneMatch(e -> e == value)) {
                lists.add(new ArrayList<>());
            }
            lists.get(lists.size() - 1).add(value);
        }, (l1, l2) -> {
            throw new RuntimeException("not supported for parallel streams");
        });