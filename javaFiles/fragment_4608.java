public static final String MEDIA_TYPE_JSONLD  = "application/ld+json";

@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.valueOf(MEDIA_TYPE_JSONLD));
    }
}