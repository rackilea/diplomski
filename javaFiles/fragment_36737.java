public class Main extends Application {

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage stage) throws MalformedURLException {
    WebView webView = new WebView();
    WebEngine engine = webView.getEngine();
    engine.load(new File("PATH/TO/Index.html").toURI().toURL().toExternalForm());

    Scene scene = new Scene(webView);
    stage.setScene(scene);
    stage.show();

    //we need this to check if the document has finished loading, otherwise it would be null and throw a exception
    engine.getLoadWorker().stateProperty().addListener((obs, oldState, currentState) -> {
        if (currentState == State.SUCCEEDED) {
            Document doc = engine.getDocument();
            addListeners(doc);
        }
    });
}

private void addListeners(Document doc) {
    Element link1 = doc.getElementById("id1");
    ((EventTarget) link1).addEventListener("click", e -> {
        System.out.println("id1 was clicked!");
    }, false);

    Element link2 = doc.getElementById("ihatejava");
    ((EventTarget) link2).addEventListener("click", e -> {
        System.out.println("ihatejava was clicked!");
    }, false);
}
}