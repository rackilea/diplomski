List<Long> categoryIds = ...; // Provided by the user
BooleanJunction<?> categoryIdJunction = queryBuilder.bool();
for ( categoryId : categoryIds ) {
    categoryIdJunction.should(
        queryBuilder
            .keyword()
            .onField("category.id")
            .matching(categoryId)
            .createQuery();
    );
}
org.apache.lucene.search.Query categoryIdQuery = categoryIdJunction.createQuery();