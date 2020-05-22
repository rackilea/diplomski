return new Docket( DocumentationType.SWAGGER_2 )
        .select()
            .apis( RequestHandlerSelectors.any() )
            .paths(PathSelectors.regex("(?!/error).+")).paths(PathSelectors.regex("(?!/product).+"))
            .build()
        .apiInfo( metadata() );