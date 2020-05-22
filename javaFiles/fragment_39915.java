for (GroupDocs groupDocs : documentGroups) {

    if (groupDocs.totalHits == 0) {
        continue;
    }

    for (int doc : groupDocs.scoreDocs) {

        Document document = reader.document(doc);
        ...
    }
}