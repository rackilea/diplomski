public class BaseWorker<C extends BaseConfig> {

    public <C extends BaseConfig> BaseWorker(final C config) {
        config.print();
    }
}