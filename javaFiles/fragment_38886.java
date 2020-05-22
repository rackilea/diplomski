public class Foo implements MessageSourceAware {

    protected MessageSource messageSource;

    ...

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    ...

    public String bar(HttpServletRequest request, ...) {
        return messageSource.getMessage("xyz.abc", 
                new Object[] { "arg1", "arg2" }, 
                RequestContextUtils.getLocale(request));
    }
}