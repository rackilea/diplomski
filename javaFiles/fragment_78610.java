@Resource Properties properties1
@Resource Properties properties2

@Bean
Properties mergedProperties(){
    Properties mergedProperties = new Properties();
    mergedProperties.putAll(properties1);
    mergedProperties.putAll(properties2);
    return mergedProperties;
}