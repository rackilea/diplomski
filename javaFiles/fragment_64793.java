String genre  = "SELECT book.genre FROM Book book  GROUP BY genre";
    SQLQuery query= session.createSQLQuery(genre);
    List<String>  genreList = query.list();

    String count = "SELECT  COUNT(genre) AS counter FROM book book  GROUP BY genre";
    query= session.createSQLQuery(count);
    List<Integer>  countList = query.list();

   Map<String, Integer> task4List = new HashMap<String, Integer>();
    for (String genre : genreList) {
         task4List.put(genre ,countList.get(genreList.indexOf(genre)));
    }