org.apache.lucene.search.Query titleQuery = queryBuilder
        .keyword()
        .onField("title")
        .matching(queryString)
        .createQuery();
org.apache.lucene.search.Query luceneQuery = queryBuilder.bool()
        .must( categoryIdQuery )
        .must( titleQuery )
        .createQuery();