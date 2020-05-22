public class MainClass implements IHelper {
    Helper mPublisher;
    ...
    void someMethod() {
        mPublisher.setSubscriber(this);
    }
    ...
}