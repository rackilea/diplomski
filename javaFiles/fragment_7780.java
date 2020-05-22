public class MyOtherBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ApplicationBean app;

    public void setApp(ApplicationBean app) {
        this.app = app;
    }

    public void doSomething() {
        // App is already here
        // no need to resolve it
        if (app.isGodMode()) {
            //do something;
        }
    }
}