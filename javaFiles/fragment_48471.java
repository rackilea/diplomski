String insert_query = "insert into " + keyspace + "." + tblName
            + " (a, b, c, d,"
            + "e, f, g, h, i, j,"
            + "k, l, m, n)  VALUES "
            + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    List<ResultSetFuture> futures = new ArrayList<ResultSetFuture>();
    PreparedStatement statement = session.prepare(insert_query);
    BoundStatement bind = null;
    int max = 1000000;

    for (int i = 0; i < max; i++) {
        bind = statement.bind(i,
                null,
                null,
                null
        );
        ResultSetFuture resultSetFuture = session.executeAsync(bind);
        futures.add(resultSetFuture);

        if (futures.size() % 500 == 0 || i == max - 1) {
            for (ResultSetFuture future : futures) {
                future.getUninterruptibly(15000, TimeUnit.MILLISECONDS);
            }
            futures.clear();
        }
    }