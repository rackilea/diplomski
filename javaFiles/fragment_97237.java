Button a = new Button();
a.setId("A");
Button b = new Button();
b.setId("B");
Button c = new Button();
c.setId("C");
somePane.getChildren().addAll(a, b, c);

// ...

Button button = (Button) somePane.lookup("#B");