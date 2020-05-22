public class FxWebViewSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();

        final WebView wView = new WebView();
        wView.setId("my_view");
        wView.setPrefHeight(200);
        wView.setPrefWidth(200);
        final WebEngine engine = wView.getEngine();
        engine.setJavaScriptEnabled(true);
        engine.loadContent("<body contentEditable='true'><div id='content'>Initial Text</div><div id='first'>My first web view in fx</div></body><span id='second'>My first web view in fx</span><span id='second'>My first web view in fx</span><span id='second'>My first web view in fx</span><span id='second'>My first web view in fx</span><span id='second'>My first web view in fx</span><span id='second'>My first web view in fx</span><span id='second'>My first web view in fx</span><span id='second'>My first web view in fx</span><div id='first'>My first web view in fx</div></body></body>");

        Button appendbtn = new Button("Append Text to Web View");

        TextArea area = new TextArea();
        area.setText("My text area");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(wView, appendbtn);
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        appendbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                /** To append html and text contents to web view */
                String webViewContents = (String) engine
                        .executeScript("document.documentElement.outerHTML");
                String appendContent = "<div id='append'>Appended html content</div> Appended text content";

                StringBuilder scrollHtml = scrollWebView(0, 50);

                engine.loadContent(scrollHtml + webViewContents + appendContent);
            }
        });

    }

    public static StringBuilder scrollWebView(int xPos, int yPos) {
        StringBuilder script = new StringBuilder().append("<html>");
        script.append("<head>");
        script.append("   <script language=\"javascript\" type=\"text/javascript\">");
        script.append("       function toBottom(){");
        script.append("           window.scrollTo(" + xPos + ", " + yPos + ");");
        script.append("       }");
        script.append("   </script>");
        script.append("</head>");
        script.append("<body onload='toBottom()'>");
        return script;
    }
}