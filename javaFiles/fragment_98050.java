...
HBox box5 = createBox();
Circle c5 = new Circle(20);
c5.setScaleX(scale);
c5.setScaleY(scale);
box5.getChildren().add(new Group(c5));
box5.getChildren().add(new Label("Test with the Scale transform and a group"));
...