public abstract class BlindListener extends MyAbstractEventListener<IMyEvent> {

    public abstract void handleEvent();

    @Override
    public void handleEvent(IMyEvent iMyEvent) {
        handleEvent(); // delegate to abstract method that ignores the argument
    }
}