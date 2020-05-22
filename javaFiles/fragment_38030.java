BooleanQuery bQuery = new BooleanQuery();
    Session session = persistence.currentManager();
    FullTextSession fullTextSession = Search.getFullTextSession(session);
    Analyzer analyzer = fullTextSession.getSearchFactory().getAnalyzer("searchtokenanalyzer");
    QueryParser parser = new QueryParser(Version.LUCENE_35, "title", analyzer);
    String[] tokenized=null;
    try {
    Query query=    parser.parse(searchString);
    String cleanedText=query.toString("title");
     tokenized = cleanedText.split("\\s");

    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    QueryBuilder qBuilder = fullTextSession.getSearchFactory()
            .buildQueryBuilder().forEntity(LearningGoal.class).get();
    for(int i=0;i<tokenized.length;i++){
         if(i==(tokenized.length-1)){
            Query query = qBuilder.keyword().wildcard().onField("title")
                    .matching(tokenized[i] + "*").createQuery();
                bQuery.add(query, BooleanClause.Occur.MUST);
        }else{
            Term exactTerm = new Term("title", tokenized[i]);
            bQuery.add(new TermQuery(exactTerm), BooleanClause.Occur.MUST);
        }
    }
        for (LearningGoal exGoal : existingGoals) {
        Term omittedTerm = new Term("id", String.valueOf(exGoal.getId()));
        bQuery.add(new TermQuery(omittedTerm), BooleanClause.Occur.MUST_NOT);
    }
    org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(
            bQuery, LearningGoal.class);