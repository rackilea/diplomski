public class GettextMessageInterpolator implements MessageInterpolator {

    private final MessageInterpolator delegate;

    public GettextMessageInterpolator() {
        this.delegate = new ResourceBundleMessageInterpolator();
    }

    @Override
    public String interpolate(String message, Context context) {
        return this.interpolate(message, context, ClientLocalLocator.get());
    }

    @Override
    public String interpolate(String message, Context context, Locale locale) {   
        I18n i18n = ClientLocalLocator.getI18n();
        String retVal = i18n.tr(message);
        if (StringUtils.isNotBlank(retVal))
            return retVal;
        return delegate.interpolate(message, context, locale);
    }

}