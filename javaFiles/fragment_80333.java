@Bean
public Docket orderApi() {
    // This will group the endpoints strting with /order.   
    // And it will be visible as a separate group in the drop down(In Swagger UI) 
    // with the name 'order' as specified in the groupName(..)
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("order")
            .apiInfo(metadata())
            .select()
            .paths(PathSelectors.ant("/order/**"))
            .build();
}

@Bean
public Docket orderValidationApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .groupName("product")
            .apiInfo(metadata())
            .select()
            .paths(PathSelectors.ant("/product/**"))
            .build();
}