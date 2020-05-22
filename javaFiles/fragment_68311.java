Query q = new Query("Email");
q.setFilter(new FilterPredicate("name", FilterOperator.EQUAL, "John");
List<Entity> entities = datastore.prepare(q).asList(FetchOptions.Builder.withDefaults());
if (entities.isEmpty()) {
    // no entities with name "John"
}