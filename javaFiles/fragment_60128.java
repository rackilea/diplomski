Button btn = new Button();
Rectangle rect = new Rectangle(400, 10);
GridPane root = new GridPane();
root.getRowConstraints().add(new RowConstraints(200));

final Line l1 = new Line(0, 0, 400, 0);

btn.setText("Say 'Hello World'");
btn.setOnAction((ActionEvent event) -> {
    System.out.println("Hello World!");
});

l1.setStroke(Color.YELLOW);
l1.setStrokeWidth(2);
root.addColumn(0, btn, l1, rect);