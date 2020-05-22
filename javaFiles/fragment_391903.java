public static void main(String [] args) {

    [...]

    MyAppHandler appHandler = new MyAppHandler(args);
    CefApp.addAppHandler(appHandler);

    CefApp app = CefApp.getInstance(args);
    CefClient client = app.createClient();
    CefBrowser browser = client.createBrowser("http://www.google.com", false, false);

    [...]
}