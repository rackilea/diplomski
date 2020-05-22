public class I18nShorthandInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(I18nShorthandInterceptor.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver localeResolver;

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("msg", new DelegationMap(localeResolver.resolveLocale(request)));

        return true;
    }

    private class DelegationMap extends AbstractMap<String, String> {
        private final Locale locale;

        public DelegationMap(Locale locale) {
            this.locale = locale;
        }

        @Override
        public String get(Object key) {
            try {
                return messageSource.getMessage((String) key, null, locale);
            } catch (NoSuchMessageException ex) {
                logger.warn(ex.getMessage());
                return (String) key;
            }
        }
        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            // no need to implement this
            return null;
        }

    }
}