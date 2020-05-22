public class Main extends Application {

    // using the base class of layout panes
    Pane pane = new Pane();
    Polygon polygon = new Polygon();

    @Override
    public void start(Stage primaryStage) {

        // what to do when the mouse is clicked
        pane.setOnMouseClicked(e -> {
            double drawX = e.getX();// position of mouse in X axle
            double drawY = e.getY();// position of mouse in y axle

            if (e.getButton() == MouseButton.PRIMARY) {// get the position of the mouse point when user left click
                Circle circle = makeCircle(drawX, drawY);// using the makeCircle method to draw the circle where the mouse is at the click
                pane.getChildren().add(circle);
                circle.setOnMouseClicked( event -> {
                    deleteCircle(circle);
                    // consume event so that the pane on click does not get called
                    event.consume();
                });
                redrawPolygon();
            }

        });

        polygon = new Polygon();
        polygon.setFill(Color.TRANSPARENT);
        polygon.setStroke(Color.BLACK);
        pane.getChildren().add(polygon);

        // container to show all context in a 500px by 500px windows
        try {
            Scene scene = new Scene(pane, 500, 500);// size of the scene
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method to draw the circle when left click
    private Circle makeCircle(double drawX, double drawY) {
        Circle circle = new Circle(drawX, drawY, 7, Color.CORAL);// create the circle and its properties(color: coral to see it better)
        circle.setStroke(Color.BLACK);// create the stroke so the circle is more visible
        return circle;
    }

    private void redrawPolygon() {
        int numOfCircles = pane.getChildren().size() - 1;
        if ( numOfCircles > 0 ) {
            polygon.getPoints().clear();
            for ( int i = 0; i <= numOfCircles; i++ ) {
                Node node = pane.getChildren().get(i);
                if ( node.getClass() == Circle.class ) {
                    polygon.getPoints().addAll(
                            ((Circle) node).getCenterX(),
                            ((Circle) node).getCenterY()
                    );
                }
            }
        }
    }

    private void deleteCircle(Circle circle){
        pane.getChildren().remove(circle);
        redrawPolygon();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}