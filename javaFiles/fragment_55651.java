root.widthProperty().addListener((o, oldValue, newValue) -> {
    double maxWidth = tp.getChildren()
                        .stream()
                        .filter(n -> n instanceof Region)
                        .map(n -> ((Region) n).getWidth())
                        .max(Double::compareTo)
                        .orElse(0d);

    tp.setPrefColumns(Math.min(tp.getChildren().size(),
            Math.max(1, (int) (newValue.doubleValue() / maxWidth))));
});

Stream.iterate(0, i -> i + 1).limit(5).forEach(i -> {
    Region r = new Region();
    Random random = new Random();
    r.setPrefSize(random.nextInt(150) + 50, random.nextInt(150) + 50);
    System.out.println(r.getPrefWidth());
    System.out.println(r.getPrefHeight());
    r.setStyle("-fx-background-color: red; -fx-border-color: blue; -fx-border-width: 1;");

    tp.getChildren().add(r);
});