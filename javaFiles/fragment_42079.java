import com.apollographql.apollo.gradle.ApolloSchemaIntrospectionTask

class ApolloIntrospect extends ApolloSchemaIntrospectionTask {}

task introspectSchema(type: ApolloIntrospect) {
    url = "http://api.githunt.com/graphql"
    output = project.projectDir.absolutePath + 'schema.json'
}