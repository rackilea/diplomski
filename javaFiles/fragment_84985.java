public class Window3DController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Group group;

    private Window3DBuilder window3dBuilder;
    private PerspectiveCamera perspectiveCamera;

    @FXML
    public void initialize() {
        perspectiveCamera = new PerspectiveCamera(true);

        window3dBuilder = new Window3DBuilder(group, perspectiveCamera);
        window3dBuilder.createScene();

        group.sceneProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                group.getScene().setCamera(perspectiveCamera);
                group.sceneProperty().removeListener(this);
            }
        });
    } 

}