@Configuration
public class ApplicationConfig {
    private static final List<String> ALLOW_HEADER_LIST = Arrays.asList("correlationid", "userid", "accept-language", "loginid", "channelid");

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HttpHeaders httpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpServletRequest curRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Enumeration<String> headerNames = curRequest.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String header = headerNames.nextElement();
                String value = curRequest.getHeader(header);
                if (ALLOW_HEADER_LIST.contains(header.toLowerCase())) {
                    log.info("Adding header {} with value {}", header, value);
                    httpHeaders.add(header, value);
                } else log.debug("Header {} with value {} is not required to be copied", header, value);
            }
        }


        return httpHeaders;
    }
}