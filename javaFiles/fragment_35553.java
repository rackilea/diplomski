GraphQLSchema schema = new GraphQLSchemaGenerator()
                    .withBasePackages("entities")
                    .withResolverBuilders(new AnnotatedResolverBuilder())
                    .withOperationsFromSingleton(examService)
                    .withValueMapperFactory(new JacksonValueMapperFactory())
                    .generate();