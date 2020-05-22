String[][] arr = {{"One", "Two"}, {null, "Four"}};
AtomicInteger rows = new AtomicInteger();
Arrays.stream(arr).forEach(subArr -> {
    int row = rows.getAndIncrement();
    AtomicInteger colums = new AtomicInteger();
    Arrays.stream(subArr).forEach(e -> iterateAction(row, colums.getAndIncrement(), e, e == null));
});