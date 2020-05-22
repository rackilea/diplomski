@Bean
    @ConfigurationProperties("en")
    public LanguageConfig engConfig() {
        return new LanguageConfig();
    }

    @Bean
    @ConfigurationProperties("sp")
    public LanguageConfig spanishConfig() {
        return new LanguageConfig();
    }