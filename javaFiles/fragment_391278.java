public class LocaleFactory
        extends AbstractContainerRequestValueFactory<Local> {

    @Override
    public Locale provide() {
        ContainerRequest cr = getContainerRequest();
    }
}