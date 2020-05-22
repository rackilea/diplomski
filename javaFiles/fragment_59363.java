//set up the server limits using apache file-upload config
@Bean
public CommonsMultipartResolver multipartResolver() {
    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
    resolver.setMaxUploadSize(2 * 1024 * 1024 * 1024); // 2 GB limit set for file upload
    resolver.setDefaultEncoding("utf-8");
    return resolver;
    }