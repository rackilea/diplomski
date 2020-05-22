@Bean
MessageSource myMessageSource() {
    ResourceBundleMessageSource r = new ResourceBundleMessageSource();
    r.setBasenames("/messages/sample");
    r.setDefaultEncoding("UTF-8");
    return r;
}