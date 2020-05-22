@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerconf() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo("2.0"))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder()
                .title("API")
                .description("REST API")
                .version(version)
                .build();
    }
}