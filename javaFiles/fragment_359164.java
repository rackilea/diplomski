public class UkCurrencyNameProvider extends CurrencyNameProvider {
private static final Locale XX_YY = new Locale("xx", "YY");
private static final Locale UK_UA = new Locale("uk", "UA");
private static final Map<Locale, String> SYMBOL_MAP;
static {
SYMBOL_MAP = new HashMap<Locale, String>();
UkCurrencyNameProvider.SYMBOL_MAP.put(UkCurrencyNameProvider.XX_YY,
        "BungaBunga");
UkCurrencyNameProvider.SYMBOL_MAP.put(UK_UA, "ungarn$$$");
}
private static final Locale[] AVAILABLE_LOCALES = UkCurrencyNameProvider.SYMBOL_MAP
        .keySet().toArray(
                new Locale[UkCurrencyNameProvider.SYMBOL_MAP.size()]);

/*
 * (non-Javadoc)
 * @see java.util.spi.CurrencyNameProvider#getSymbol(java.lang.String,
 * java.util.Locale)
 */
@Override
public String getSymbol(final String currencyCode, final Locale locale) {
    final String result;
    if ("UAH".equals(currencyCode)) {
    result = UkCurrencyNameProvider.SYMBOL_MAP.get(locale);
    } else {
    result = null;
    }
    return result;
}

/*
 * (non-Javadoc)
 * @see java.util.spi.LocaleServiceProvider#getAvailableLocales()
 */
@Override
public Locale[] getAvailableLocales() {
    return UkCurrencyNameProvider.AVAILABLE_LOCALES.clone();

}