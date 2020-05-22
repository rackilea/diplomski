@Autowired
private TypeResolver resolver;

@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()

            ...

            .additionalModels(resolver.resolve(Pojo.class));
}