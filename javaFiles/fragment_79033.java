@Override
public void postInit(Scene scene) {
    Swatch.BLUE.assignTo(scene);

    scene.getStylesheets().setAll(
        getClass().getResource("style.css").toExternalForm()); 
}