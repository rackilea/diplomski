@Component
    public static class RestTemplateInitializer implements ApplicationListener<ApplicationReadyEvent> {

        public static HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();

        @Override
        public void onApplicationEvent(ApplicationReadyEvent e) {
            clientHttpRequestFactory.setConnectTimeout(10000);
            clientHttpRequestFactory.setReadTimeout(10000);
        }


    }