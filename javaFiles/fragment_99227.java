public class SubDomainLocaleResolver extends AbstractLocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String domain = request.getServerName();
        String language = domain.substring(0, domain.indexOf('.'));
        Locale  locale = StringUtils.parseLocaleString(language);
        if (locale == null) {
            locale = determineDefaultLocale(request);
        }
        return locale != null ? locale : determineDefaultLocale(request);
    }

    protected Locale determineDefaultLocale(HttpServletRequest request) {
        Locale defaultLocale = getDefaultLocale();
        if (defaultLocale == null) {
            defaultLocale = request.getLocale();
        }
        return defaultLocale;
    }    

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        throw new UnsupportedOperationException("Cannot change sub-domain locale - use a different locale resolution strategy");

    }
}