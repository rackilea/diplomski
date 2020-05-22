@Configuration
public class SwaggerConfiguration {

    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .additionalModels(typeResolver.resolve(TestDTO.class));
    }

}