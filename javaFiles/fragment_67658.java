private void sortUsingRelevance(String searchQuery)
            throws IOException, ParseException
    {
        searcher = new Searcher(indexDir);
        long startTime = System.currentTimeMillis();

        //create a term to search file name
        Term term = new Term(LuceneConstants.paragraph, searchQuery);
        //create the term query object
        Query query = new FuzzyQuery(term);
        searcher.setDefaultFieldSortScoring(true, false);
        //do the search
        TopDocs hits = searcher.search(query, Sort.RELEVANCE);
        long endTime = System.currentTimeMillis();

        System.out.println(hits.totalHits
                + " documents found. Time :" + (endTime - startTime) + "ms");
        DefaultListModel listModel = new DefaultListModel();
        for (ScoreDoc scoreDoc : hits.scoreDocs) {

            Document doc = searcher.getDocument(scoreDoc);
            listModel.addElement(doc.get(LuceneConstants.paragraph));
            jList1.setModel(listModel);

        }
        searcher.close();
    }