public void start(Stage stage) throws Exception {
    final VBox vb = new VBox();

    final Button button1 = new Button("Button 1");
    final Button button2 = new Button("Button 2");
    final Button button3 = new Button("Button 3");

    TraversalEngine engine = new TraversalEngine(vb, false) {
        @Override
        public void trav(Node node, Direction drctn) {
            int index = vb.getChildren().indexOf(node);

            switch (drctn) {
                case DOWN:
                case RIGHT:
                case NEXT:
                    index++;
                    break;
                case LEFT:
                case PREVIOUS:
                case UP:
                    index--;
            }

            if (index < 0) {
                index = vb.getChildren().size() - 1;
            }
            index %= vb.getChildren().size();

            System.out.println("Select <" + index + ">");

            vb.getChildren().get(index).requestFocus();
        }
    };

    vb.setImpl_traversalEngine(engine);

    vb.getChildren().addAll(button1, button2, button3);
    Scene scene = new Scene(vb);
    stage.setScene(scene);
    stage.show();
}