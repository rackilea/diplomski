@Bean
    @Primary
    public WeatherGauge weatherGauge2() {
        return new WeatherGauge("40 F");
    } 

    @Bean
    public WeatherGauge weatherGauge() {
        return new WeatherGauge("20 C");
    }