@Bean
public static Filter requestLoggingFilter() {
    final CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
    loggingFilter.setIncludePayload(true);
    loggingFilter.setMaxPayloadLength(512);

    return loggingFilter;
}