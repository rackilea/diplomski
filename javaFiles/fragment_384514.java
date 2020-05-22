public class LocalizedMessageSource {

  private final MessageSource messageSource;
  private final LocaleResolver localeResolver;

  public LocalizedMessageSource(MessageSource messageSource, 
                                LocaleResolver localeResolver) {
    Assert.notNull(messageSource);
    Assert.notNull(localeResolver);
    this.messageSource = messageSource;
    this.localeResolver = localeResolver;
  }

  public String getMessage(MessageSourceResolvable resolvable) {
    return messageSource.getMessage(resolvable, getLocale());

  public String getMessage(String code, Object[] args) {
    return messageSource.getMessage(code, args, getLocale());

  getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
    return messageSource.getMessage(code, args, defaultMessage, getLocale()); 
  }

  private Locale getLocale() {
    return localeResolver.resolveLocale(getCurrentRequest());
  }

  private HttpServletRequest getCurrentRequest() {
    return ((ServletRequestAttributes) RequestContextHolder
      .currentRequestAttributes()).getRequest();
  }
}