package com.stackoverflow;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

// Junit class
public class TableDeserExample {
    // sample input
    String inputJson = "{\n" +
            "    \"Results\": {\n" +
            "        \"output1\": {\n" +
            "            \"type\": \"table\",\n" +
            "            \"value\": {\n" +
            "                \"ColumnNames\": [\"userId\", \"documentId\", \"Scored Labels\", \"Scored Probabilities\"],\n" +
            "                \"ColumnTypes\": [\"String\", \"String\", \"Boolean\", \"Double\"],\n" +
            "                \"Values\": [[\"100213199594809000000\", \"1Ktol-SWvAh8pnHG2O7HdPrfbEVZWX3Vf2YIPYXA_8gI\", \"False\", \"0.375048756599426\"], [\"103097844766994000000\", \"1jYsTPJH8gaIiATix9x34Ekcj31ifJMkPNb0RmxnuGxs\", \"True\", \"0.753859758377075\"]]\n"
            +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";

    // POJO to map the Json structure. You may want to make it generalize based
    // on field "type"
    // (https://github.com/FasterXML/jackson-docs/wiki/JacksonPolymorphicDeserialization)
    public static class Result {
        private String type;
        private TableResult value;

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setValue(TableResult value) {
            this.value = value;
        }

        public TableResult getValue() {
            return this.value;
        }
    }

    // Pojo for table result
    public static class TableResult {
        private List<String> columnNames;
        private List<String> columnTypes;
        private List<Object[]> values;

        @JsonProperty("ColumnNames")
        public List<String> getColumnNames() {
            return this.columnNames;
        }

        public void setColumnNames(List<String> columnNames) {
            this.columnNames = columnNames;
        }

        @JsonProperty("ColumnTypes")
        public List<String> getColumnTypes() {
            return this.columnTypes;
        }

        public void setColumnTypes(List<String> columnTypes) {
            this.columnTypes = columnTypes;
        }

        @JsonProperty("Values")
        public List<Object[]> getValues() {
            return this.values;
        }

        public void setValues(List<Object[]> values) {
            this.values = values;
        }

    }

    // Top level Json POJO
    public static class ResultContainer {
        private Map<String, Result> results;

        @JsonProperty("Results")
        public Map<String, Result> getResults() {
            return this.results;
        }

        public void setResults(Map<String, Result> results) {
            this.results = results;
        }
    }

    // A contract to map the result "values" to the expected object
    public static interface ResultMapper<T> {
        T map(TableResult map, Object[] row);
    }

    // Basic implementation for mapping user object from json "values[i]" array
    public static class UserTableResultMapper implements ResultMapper<User> {

        @Override
        public User map(TableResult result, Object[] row) {
            User user = new User();
            // Here use any mapper logic based on column name
            // Retrieved from result object.
            // Below are for illustration only
            user.setId(String.valueOf(row[0]));
            user.setDocumentId(String.valueOf(row[1]));
            return user;
        }

    }

    // A result reader class
    public static class ResultReader<T> implements Iterable<T> {
        private TableResult result;
        private ResultMapper<T> mapper;

        public ResultReader(TableResult result, ResultMapper<T> mapper) {
            this.result = result;
            this.mapper = mapper;
        }

        @Override
        public Iterator<T> iterator() {
            final Iterator<Object[]> itr = result.getValues().iterator();
            return new Iterator<T>() {

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override
                public T next() {
                    Object[] values = itr.next();
                    return mapper.map(result, values);
                }

                @Override
                public boolean hasNext() {
                    return itr.hasNext();
                }
            };
        };
    }

    public static class User {
        private String id;
        private String documentId;
        // and others

        public String getId() {
            return this.id;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDocumentId() {
            return this.documentId;
        }

    }

    @Test
    public void simpleTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ResultContainer file = mapper.readValue(inputJson, ResultContainer.class);
        Result result = file.getResults().get("output1");
        ResultReader<User> userResultReader = new ResultReader<>(result.getValue(), new UserTableResultMapper());
        for (User user : userResultReader) {
            System.out.println(user.getId() + " : " + user.getDocumentId());
        }
    }
}