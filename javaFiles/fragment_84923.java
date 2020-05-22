@Bean
public CommonsMultipartResolver getCommonsMultipartResolver() {
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    resolver.setMaxUploadSize(yourMaxSizeToUpload);
    return resolver;
}