BooleanJunction junction = builder.bool();
must(junction, createQuery(field1, term1));
must(junction, createQuery(field2, term2));
query = junction.createQuery();

void must(BooleanJunction junction, Query query) {
    if (query != null) {
        junction.must(query);
    }
}

Query createQuery(String field, Object term) {
     if(term != null) {
          return builder.keyword().onField(field).matching(term).createQuery();
     }
     return null;
}