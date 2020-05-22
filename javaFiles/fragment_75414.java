@Bean
public ConversionServiceFactoryBean conversionService() {
    ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
    Set<Converter<?, ?>> myConverters = new HashSet<>();
    myConverters.add(new Converter<String, LocalTime>() {
        @Override
        public LocalTime convert(String source) {
            return LocalTime.parse(source);
        }
    });
    conversionServiceFactoryBean.setConverters(myConverters);
    return conversionServiceFactoryBean;
}