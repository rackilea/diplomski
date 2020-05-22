public class SignServiceProvider implements Provider<SignService> {

    @Inject
    private SwordfishConfiguration configuration;

    @Override
    public SignService get() {
        return new SignServiceImpl(configuration.getAmazon());
    }
}