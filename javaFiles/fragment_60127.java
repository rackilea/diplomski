Button btn = new Button();
VBox root = new VBox();

final Line l1 = new Line(0, 200, 400, 200);
final Line l2 = new Line(0, 300, 400, 300);

l1.setManaged(false);
l2.setManaged(false);

btn.setText("Say 'Hello World'");
btn.setOnAction((ActionEvent event) -> {
    System.out.println("Hello World!");
});

l1.setStroke(Color.YELLOW);
l1.setStrokeWidth(2);
l2.setStroke(Color.YELLOW);
l2.setStrokeWidth(2);
root.getChildren().addAll(btn, l1, l2, rect);