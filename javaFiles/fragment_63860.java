public class AltsMatcherProvider implements Provider<IAltsPairsMatcher> {

    @Inject Provider<AltsPairsMatcherByName> regularProvider;
    @Inject Provider<AltsPairsMatcherBySegments> bidiProvider;

    @Override
    public IAltsPairsMatcher get() {

        switch (System.getProperty(regressionType)) {
            default:
            case "regular": {
                return regularProvider.get();
            }
            case "bidi": {
                return bidiProvider.get();
            }
        }
    }
}