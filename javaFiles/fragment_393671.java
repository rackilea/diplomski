@Bean
public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.xxx.yyy.resource"))
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(commonParameters())
            .apiInfo(apiInfo())
            .ignoredParameterTypes(TokenInfo.class, HttpServletRequest.class, HttpServletResponse.class)
            .securityContexts(Lists.newArrayList(securityContext()))
            .securitySchemes(Lists.newArrayList(apiKey()));
}


private List<Parameter> commonParameters() {
    List<Parameter> parameters = new ArrayList<Parameter>();
    parameters.add(new ParameterBuilder()
            .name("access_token")
            .description("token for authorization")
            .modelRef(new ModelRef("string"))
            .parameterType("query")
            .required(true)
            .build());

    return parameters;
}

private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo(
            "My REST API",
            "Some custom description of API.",
            "API TOS",
            "Terms of service",
            "myeaddress@company.com",
            "License of API",
            "API license URL");
    return apiInfo;
}

private SecurityContext securityContext() {
    return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.any())
            .build();
}

List<SecurityReference> defaultAuth() {
    AuthorizationScope authorizationScope
            = new AuthorizationScope("global", "accessEverything");
    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    authorizationScopes[0] = authorizationScope;
    return Lists.newArrayList(
            new SecurityReference("AUTHORIZATION", authorizationScopes));
}

private ApiKey apiKey() {
    return new ApiKey("AUTHORIZATION", "access_token", "header");
}