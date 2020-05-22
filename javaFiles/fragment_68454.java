public List<Address> search() {
    List<Address> results = new ArrayList<>();

    BooleanQuery.Builder queryBuilder = new BooleanQuery.Builder();
    queryBuilder.setMinimumNumberShouldMatch(1);

    if(!getLineOne().equals("")) {
        //This is a MUST clause, and so doesn't factor into the minimumShouldMatch
        Query query = new FuzzyQuery(new Term("addr1", getLineOne()));
        queryBuilder.add(query, BooleanClause.Occur.MUST);
    }

    if(!getLineTwo().equals("")) {
        Query query = new FuzzyQuery(new Term("addr2", getLineTwo()));
        queryBuilder.add(query, BooleanClause.Occur.SHOULD);
    }
    if(!getCity().equals("")) {
        Query query = new FuzzyQuery(new Term("addrcity", getCity()));
        queryBuilder.add(query, BooleanClause.Occur.SHOULD);
    }
    if(!getCounty().equals("")) {
        Query query = new FuzzyQuery(new Term("addrcounty", getCounty()));
        queryBuilder.add(query, BooleanClause.Occur.SHOULD);
    }
    if(!getCountry().equals("")) {
        Query query = new FuzzyQuery(new Term("addrcountry", getCountry()));
        queryBuilder.add(query, BooleanClause.Occur.SHOULD);
    }
    if(!getPostcode().equals("")) {
        Query query = new FuzzyQuery(new Term("addrpostcode", getPostcode()));
        queryBuilder.add(query, BooleanClause.Occur.SHOULD);
    }

    try {
        Query toRun = queryBuilder.build();

        List<Document> searchResults = SearchEngine.getInstance(SEARCH_ENGINE)
                .performSearch(toRun, 50);

        searchResults.forEach(result -> {
            results.add(new Address(result));
        });
    } catch (IOException e) {
        e.printStackTrace();
    }

    return results;
}