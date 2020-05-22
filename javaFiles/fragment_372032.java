public interface MessageProvider {
    String get(String key);
}

@Component
public class MessagesProviderImpl implements MessageProvider {
    private BundleLocalization bundleLocalization;
    private LocaleProvider localeProvider;
    private ResourceBundle resourceBundle;

    @Reference
    public void bindBundleLocalization(BundleLocalization bundleLocalization) {
        this.bundleLocalization = bundleLocalization;
    }

    @Reference(cardinality = ReferenceCardinality.OPTIONAL, policy = ReferencePolicy.DYNAMIC)
    public void bindLocaleProvider(LocaleProvider localeProvider) {
        this.localeProvider = localeProvider;
        setResourceBundle()
    }

    /*unbind methods omitted*/

    @Activate
    public void activate() {
        setResourceBundle();
    }

    @Override
    public String get(String key) {
        return resourceBundle.getString(key);
    }

    private String getLocale() {
        return localeProvider != null ? localeProvider.getLocale().toString() : Locale.getDefault().toString();
    }

    private void setResourceBundle() {
        resourceBundle = bundleLocalization.getLocalization(FrameworkUtil.getBundle(getClass()), getLocale());
    }
}