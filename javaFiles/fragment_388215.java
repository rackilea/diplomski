public List<Foo> findFoos(final DateTime time) {
    return db.select(FOO.fields())
             .from("({0}) AS {1}", 
                  DSL.sql(loadSqlQuery("FooRepository_findFoos"), time),
                  DSL.name(FOO.getName()))
             .fetchInto(Foo.class);
}