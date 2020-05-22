public WebViewExample extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception
  {
    WebView webView = new WebView();
    webView.getEngine().loadContent("<html><body>Hello World :p</body></html>");
    BorderPane borderPane = new BorderPane(webView);
    primaryStage.setScene(new Scene(borderPane));
    primaryStage.show();
  }
}