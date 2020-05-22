public class MyApplication extends Application {

    @Override
    public void init() {
        setMainWindow(new Window());

        ApplicationContext context = this.getContext();
        if (context instanceof WebApplicationContext) {
            WebBrowser webBrowser = ((WebApplicationContext) this.getContext()).getBrowser();

            Date now = webBrowser.getCurrentDate(); // Returns the current date and time on the browser
        }
    }
}