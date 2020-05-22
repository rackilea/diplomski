@Bean
public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2)
      ...
      .forCodeGeneration(true)
      ...;
}