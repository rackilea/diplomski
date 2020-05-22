public class VideoTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebConsoleListener.setDefaultListener((webView, message, lineNumber, sourceId) -> {
            System.out.println(message + "[at " + lineNumber + "]");
        });

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.setJavaScriptEnabled(true);

        StringBuilder codeBuilder = new StringBuilder("<video id='test' src='http://techslides.com/demos/sample-videos/small.mp4' width='200' height='200' controls></video>");
        codeBuilder.append("<script>");
        codeBuilder.append("document.querySelector('#test').addEventListener('playing', function(e) { console.log('playing'); }, false);");
        codeBuilder.append("document.querySelector('#test').addEventListener('ended', function(e) { console.log('ended'); }, false);");
        codeBuilder.append("document.querySelector('#test').load();");
        codeBuilder.append("document.querySelector('#test').play();");
        codeBuilder.append("</script>");
        engine.loadContent(codeBuilder.toString());

        Scene scene = new Scene(webView, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}