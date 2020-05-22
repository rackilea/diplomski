public class Bridge {

    private WebEngine engine;

    public Bridge(WebEngine engine) {
        this.engine = engine;
    }
    public void call() {
        //System.out.println("do call");
        engine.executeScript("addPoint(0,-26.487000,151.984000)");
    }
}