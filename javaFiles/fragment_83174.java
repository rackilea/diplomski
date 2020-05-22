public class BehaviorListenerInstanceCreator implements InstanceCreator<BehaviorListener> {
    @Override
    public BehaviorListener createInstance(Type type) {
        InputListener ajax = new InputListener();

        return ajax;
    }
}