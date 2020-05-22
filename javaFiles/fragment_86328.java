PreparedStatement prepared = session.prepare("insert into names (id, name) values (?, ?)");

int numberOfConcurrentQueries = 100;
final Semaphore semaphore = new Semaphore(numberOfConcurrentQueries);

int id = 0;    

for(int i = 0; i < myList.size(); i++) {
    try {
        id += 1;
        semaphore.acquire();
        ResultSetFuture future = session.executeAsync(prepared.bind(id, myList.get(i)));
        Futures.addCallback(future, new FutureCallback<ResultSet>() {
            @Override
            public void onSuccess(ResultSet result) {
                semaphore.release();
            }

            @Override
            public void onFailure(Throwable t) {
                semaphore.release();
            }
        });
    } catch (Exception e) {
        semaphore.release();
        e.printStackTrace();
    }
}