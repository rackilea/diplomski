public class JavaApplication {
    public void exit() {
        Platform.exit();
    }
}
...
JavaApplication javaApp = new JavaApplication();
JSObject window = (JSObject) webEngine.executeScript("window");
window.setMember("app", javaApp);