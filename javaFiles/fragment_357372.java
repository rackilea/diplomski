@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [MinerepoApplication::class])
class MinerepoApplication {
    @Bean
    fun schema() : GraphQLSchema = SchemaParser.newParser()
            .file("schema.graphqls")
            .resolvers(RootQueryResolver(), RootMutationResolver())
            .build()
            .makeExecutableSchema()
}