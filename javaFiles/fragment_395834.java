public class BaseConfig<C extends BaseConfig> {

    public BaseConfig(final Object c) {
    }

    public BaseWorker<C> getWorker() {
        return new BaseWorker<C>(this);
    }

    public void print() {
        //
    }
}