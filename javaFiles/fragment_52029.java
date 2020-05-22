List<Integer> start = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
        start.add(i + 1);
    }
    List<Integer> finish = new ArrayList<>(start);
    Collections.shuffle(finish);