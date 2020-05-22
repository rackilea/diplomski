HBox hbox = new HBox();
Button button1 = new Button("Add");
Button button2 = new Button("Remove");
HBox.setHgrow(button1, Priority.ALWAYS);
HBox.setHgrow(button2, Priority.ALWAYS);
button1.setMaxWidth(Double.MAX_VALUE);
button2.setMaxWidth(Double.MAX_VALUE);
hbox.getChildren().addAll(button1, button2);