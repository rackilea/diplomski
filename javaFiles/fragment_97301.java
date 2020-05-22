@FXML private WebView webView;



    @FXML
    public void initialize() throws IOException{
        //Some ArrayList Initialization 

        WebEngine engine = webView.getEngine();
        engine.load("file:///home/jyotiproy/Todolist/test2.html");
    }