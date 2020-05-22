public class PanelWithBox extends JFXPanel {

    public PanelWithBox() {
        setPreferredSize(new Dimension(200,100));
        Platform.runLater(this::initFx);
    }

    private void initFx() {
        Group g = new Group();
        Scene scene = new Scene(g);
        Box box = new Box(20, 30, 40);
        box.setMaterial(new PhongMaterial(Color.RED));
        box.getTransforms().addAll(Transform.translate(50, 25), new Rotate(30, new Point3D(1, 1, 1)));
        g.getChildren().add(box);
        setScene(scene);
    }
}