private double startX;
private double startY;

@Override
public void start(Stage primaryStage) {
    ImageView image = new ImageView("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/687px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg");
    ScrollPane mapScroll = new ScrollPane(image);
    Scene scene = new Scene(mapScroll, 400, 400);
    mapScroll.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
        startX = e.getX();
        startY = e.getY();
    });
    mapScroll.addEventFilter(MouseEvent.MOUSE_DRAGGED, e -> {
        double endX = e.getX();
        double endY = e.getY();
        Bounds viewBounds = mapScroll.getViewportBounds();

        double startEndX = startX - endX;
        double startEndY = startY - endY;

        Bounds contentBounds = mapScroll.getContent().getLayoutBounds();

        double hChange = startEndX / (contentBounds.getWidth() - viewBounds.getWidth());
        double vChange = startEndY / (contentBounds.getHeight() - viewBounds.getHeight());
        mapScroll.setHvalue(mapScroll.getHvalue() + hChange);
        mapScroll.setVvalue(mapScroll.getVvalue() + vChange);

        startX = endX;
        startY = endY;
    });

    primaryStage.setScene(scene);
    primaryStage.show();
}