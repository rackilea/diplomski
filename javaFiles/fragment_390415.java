Docket docket= new Docket(DocumentationType.SWAGGER_2)
            .alternateTypeRules( AlternateTypeRules.newRule(
                    typeResolver.resolve(Collection.class, Instant.class),
                    typeResolver.resolve(Collection.class, Date.class), Ordered.HIGHEST_PRECEDENCE))
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.test"))
            .paths(PathSelectors.any())
            .build();