@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})

@Bean
public CommonsMultipartResolver multipartResolver()
{
    return new CommonsMultipartResolver();
}