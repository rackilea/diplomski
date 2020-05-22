package com.googlecode.cqengine;
import com.googlecode.cqengine.attribute.*;
import com.googlecode.cqengine.query.Query;
import com.googlecode.cqengine.query.option.QueryOptions;
import com.googlecode.cqengine.query.parser.sql.SQLParser;
import java.util.*;

import static com.googlecode.cqengine.codegen.AttributeBytecodeGenerator.*;
import static com.googlecode.cqengine.query.QueryFactory.*;
import static java.util.Arrays.asList;

public class TagsExample {

    static class MyObject {
        final String name;
        final List<Long> tags;

        public MyObject(String name, List<Long> tags) {
            this.name = name;
            this.tags = tags;
        }

        static final Attribute<MyObject, Long> TAGS = new MultiValueAttribute<MyObject, Long>("tags") {
            public Iterable<Long> getValues(MyObject object, QueryOptions queryOptions) { return object.tags; }
        };
    }

    public static void main(String[] args) {
        IndexedCollection<MyObject> collection = new ConcurrentIndexedCollection<>();
        collection.add(new MyObject("foo", asList(1L, 2L, 3L)));
        collection.add(new MyObject("bar", asList(4L, 5L, 6L)));
        collection.add(new MyObject("baz", asList(7L, 8L, 9L)));

        // Search via a programmatic query...
        Query<MyObject> nativeQuery = in(MyObject.TAGS, asList(3L, 9L));
        collection.retrieve(nativeQuery)
                .forEach(object -> System.out.println(object.name));
        // ..prints: foo, baz


        // Search via an SQL query...
        String sqlQuery = "SELECT * FROM collection WHERE tags IN (3, 9)";
        SQLParser<MyObject> parser = SQLParser.forPojoWithAttributes(MyObject.class, createAttributes(MyObject.class));
        parser.retrieve(collection, sqlQuery)
                .forEach(object -> System.out.println(object.name));
        // ..prints: foo, baz
    }
}