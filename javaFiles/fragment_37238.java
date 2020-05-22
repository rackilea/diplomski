List<Bson> filters = new ArrayList<>();

// populate filters, as per your filterQueryForSuppWarning() 
// ...

AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
        // wrap your list of filters in an 'and' and assign that directly to the $match stage
        Aggregates.match(Filters.and(filters)),
        Aggregates.project(Projections.include("id_sup_number", "sup_name",
                "group_name", "code_supplier_dlpa_site", "idPnPartNumber"))
));