for (GroupDocs<BytesRef> group : d) {
    for (ScoreDoc scoredoc : group.scoreDocs) {
        Document doc = is.doc(scoredoc.doc);
        //Do stuff
    }
}