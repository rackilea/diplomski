import graphql.GraphQL;
import graphql.schema.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

public class Example2 {


    public class TestDataFetcher implements DataFetcher {
        public Object get(DataFetchingEnvironment environment) {
            String id = (String)environment.getArgument("id");
            return id;
        }
    }

    public static void main(final String[] args)  {
        Example2 app = new Example2();
        app.run();
    }
    void run() {
         TestDataFetcher testDataFetcher = new TestDataFetcher();   

         List<GraphQLFieldDefinition> fields = new ArrayList<GraphQLFieldDefinition>();

            fields.add(createGroupField(testDataFetcher));
                fields.add(createNameField());
                fields.add(createVersionField());

         GraphQLObjectType queryType = newObject()
                .name("query")
                .fields(fields)
                .build();

         GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();
        String query = null;
        try {
              query = FileUtils.readFileToString(
                    new File("src/main/resources/query1.txt"),
                    "UTF-8"
            );
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        if(query!=null) {
            Map<String, Object> result = (Map<String, Object>) new GraphQL(schema).execute(query).getData();
            System.out.println(result);
        }
    }

    private GraphQLFieldDefinition createVersionField() {
         GraphQLArgument arg = newArgument().name("id").type(GraphQLString).build();
        return newFieldDefinition().type(GraphQLString).name("version").argument(arg).build();
    }

    private GraphQLFieldDefinition createNameField() {
        GraphQLArgument arg = newArgument().name("name").type(GraphQLString).build();
        return newFieldDefinition().type(GraphQLString).name("name").argument(arg).build();
    }

    private GraphQLFieldDefinition createGroupField(TestDataFetcher testDataFetcher) {
        final GraphQLArgument idArg = newArgument().name("id").type(GraphQLString).build();
        return newFieldDefinition()
                .type(GraphQLString)
                .name("group")
                .dataFetcher(testDataFetcher)
                .argument(idArg)
                .build();
    }
}