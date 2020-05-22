public static void main(String [] args) {

    [...]

    ArrayList<String> mySwitches = new ArrayList<>();
    mySwitches.add("--persist-session-cookies=true");
    CefApp app = CefApp.getInstance(mySwitches.toArray(new String[mySwitches.size()]));
    CefClient client = app.createClient();
    CefBrowser browser = client.createBrowser("http://www.google.com", false, false);

    [...]
}