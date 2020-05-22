public class MyLogger extends Logger {
    final Logger target;
    protected MyLogger(Logger target) {
        this.target = target;
    }

    @Override
    public void error(Object message) {
        target.error(message);
    }

    //...

}