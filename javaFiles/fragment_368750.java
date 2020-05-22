List<ResultWithQuery > list = new ArrayList<ResultWithQuery >();
    int totalThreads = allQueriesWeight.size();
    ExecutorService taskExecutor = Executors.newFixedThreadPool(totalThreads);
    for (String query : allQueriesWeight) {//allQueriesWeight is an arraylist containing sql server queries
        SearchTask searchTask = new SearchTask(query);
        Future<List> submit = taskExecutor.submit(searchTask);
        list.add(new ResultWithQuery (submit, query));
    }