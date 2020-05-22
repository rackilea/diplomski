private Query parseQueryForSong(String artist, String title, String album) throws ParseException {
    String[] artistArr = artist.split(" ");
    String[] titleArr = sanitizePhrase(title).split(" ");
    String[] albumArr = sanitizePhrase(album).split(" ");

    BooleanQuery.Builder mainQueryBuilder = new BooleanQuery.Builder();
    BooleanQuery.Builder albumQueryBuilder = new BooleanQuery.Builder();
    PhraseQuery artistQuery = new PhraseQuery("artist", artistArr);

    for (String titleWord : titleArr) {
        if (!titleWord.isEmpty()) {
            mainQueryBuilder.add(new TermQuery(new Term("title", titleWord)), BooleanClause.Occur.SHOULD);
        }
    }

    for (String albumWord : albumArr) {
        if (!albumWord.isEmpty()) {
            albumQueryBuilder.add(new TermQuery(new Term("album", albumWord)), BooleanClause.Occur.SHOULD);
        }
    }

    mainQueryBuilder.add(artistQuery, BooleanClause.Occur.MUST);
    mainQueryBuilder.add(albumQueryBuilder.build(), BooleanClause.Occur.MUST);

    StandardAnalyzer analyzer = new StandardAnalyzer();
    Query mainQuery = new QueryParser("title", analyzer).parse(mainQueryBuilder.build().toString());

    return mainQuery;
}