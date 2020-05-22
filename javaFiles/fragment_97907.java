ResultSetFuture resultSetFuture = session.executeAsync("SELECT * FROM test.t;");
    Futures.addCallback(resultSetFuture, new FutureCallback<ResultSet>() {
        @Override
        public void onSuccess(@Nullable com.datastax.driver.core.ResultSet resultSet) {
            // do nothing
        }

        @Override
        public void onFailure(Throwable throwable) {
            System.out.printf("Failed with: %s\n", throwable);
        }
    });