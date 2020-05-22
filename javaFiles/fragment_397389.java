AtomicInteger counter = new AtomicInteger();
chart.getData().forEach((t) -> {
    t.getData().forEach((j) -> {
        if (counter.getAndIncrement() % 2 == 0) {
            j.getNode().setStyle("-fx-background-color: red");
        }
        else {
            j.getNode().setStyle("-fx-background-color: blue");
        }
    });
});