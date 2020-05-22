int N = 16;
for (int i = 0; i < N; i++) {
    Circle pt = new Circle(150.0f + 100 * Math.cos(Math.PI * 2 * i / N),
            150.0f + 100 * Math.sin(Math.PI * 2 * i / N), 3.0f);
    pt.setFill(Color.BLACK);
    root.getChildren().add(pt);
}