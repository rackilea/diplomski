@Bean
    public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames( "classpath:messages" );
    // if true, the key of the message will be displayed if the key is not
    // found, instead of throwing a NoSuchMessageException
    messageSource.setUseCodeAsDefaultMessage( true );
    messageSource.setDefaultEncoding( "UTF-8" );
    // # -1 : never reload, 0 always reload
    messageSource.setCacheSeconds( 0 );

    return messageSource;
    }