IndexSearcher searcher = ...
// Some random query here I get all docs
Query query = new MatchAllDocsQuery();
// Group the docs by EntityId
GroupingSearch groupingSearch = new GroupingSearch("EntityId");
// Sort the docs of the same group by Timestamp in reversed order to get
// the most recent first
groupingSearch.setSortWithinGroup(
    new Sort(new SortField("Timestamp", SortField.Type.LONG, true))
);
// Set the limit of docs for a given group to 1 as we only want the latest
// NB: This is the default value so it is not required
groupingSearch.setGroupDocsLimit(1);
// Get the 10 first matching groups
TopGroups<BytesRef> result = groupingSearch.search(searcher, query, 0, 10);
// Iterate over the groups found
for (GroupDocs<BytesRef> groupDocs : result.groups) {
    // Iterate over the docs of a given group
    for (ScoreDoc scoreDoc : groupDocs.scoreDocs) {
        // Get the related doc
        Document doc = searcher.doc(scoreDoc.doc);
        // Print the stored value of EntityId and Timestamp
        System.out.printf(
            "EntityId = %s Timestamp = %s%n", doc.get("Id"),  doc.get("Tsp")
        );
    }
}