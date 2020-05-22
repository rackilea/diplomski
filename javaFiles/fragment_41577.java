private Scene home;
private Stage window;    

public Scene home() {
    if (home == null) {
        // build my scene
        home = new Scene(root, 300, 300)

        // or maybe do this without testing, if the scene was created before???
    }
    return home;
} 

@Override
public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setScene(home()); // use the method here
    window.show();
}