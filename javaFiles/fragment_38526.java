@Configuration
@EnableSwagger2
public class SwaggerConfig {

 @Bean
 public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors
                    .basePackage("se.dala.restserviceswagger.controller"))
            .paths(PathSelectors.any())
            .build();
 }
}