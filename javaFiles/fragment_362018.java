public class CalendarController extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        WebView browser = new WebView();

        WebEngine webEngine = browser.getEngine();

        com.sun.javafx.webkit.WebConsoleListener.setDefaultListener(
            (webView, message, lineNumber, sourceId)-> System.out.println("Console: [" + sourceId + ":" + lineNumber + "] " + message)
        );

        webEngine.load("http://calendar.google.com");

        StackPane root = new StackPane();
        root.getChildren().add(browser);

        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        launch(args);
    }
}