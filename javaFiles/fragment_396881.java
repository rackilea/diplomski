public class Main extends Application {

    public static final int SIZE = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane rootPane = new Pane();

        List<Rectangle> rects = new ArrayList<>();
        for (int j = 0; j < 2; j++) {
            for(int i = 0; i < 5; i++) {
                Rectangle r = new Rectangle(i * 100, j == 0 ? 0 : 300, 100, 200);
                r.setFill(Color.BEIGE);
                r.setStroke(Color.BLACK);
                rects.add(r);
            }
        }
        rootPane.getChildren().addAll(rects);

        Circle circle = new Circle(350, 100, 200);
        circle.setStroke(Color.BLACK);
        circle.setFill(null);
        rootPane.getChildren().add(circle);

        List<Polygon> polys = new ArrayList<>();
        for(Rectangle rect : rects) {
            polys.add(rectangleToPolygon(rect));
        }
        List<Polygon> intersects = getTotalIntersections(polys, circle);
        System.out.println(intersects);

        primaryStage.setScene(new Scene(rootPane, SIZE, SIZE));
        primaryStage.show();
    }

    public List<Polygon> getTotalIntersections(List<Polygon> polys, Shape testShape) {
        List<Polygon> intersections = new ArrayList<>();
        for(Polygon poly : polys) {
            if(totalIntersects(poly, testShape)) {
                intersections.add(poly);
            }
        }
        return intersections;
    }

    public static Polygon rectangleToPolygon(Rectangle rect) {
        double[] points = {rect.getX(), rect.getY(),
                            rect.getX() + rect.getWidth(), rect.getY(),
                            rect.getX() + rect.getWidth(), rect.getY() + rect.getHeight(),
                            rect.getX(), rect.getY() + rect.getHeight()};
        return new Polygon(points);
    }

    public static void main(String[] args) {
        Main.launch(args);
    }
}