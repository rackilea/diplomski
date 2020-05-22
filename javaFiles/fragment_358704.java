Map<Future<Foo>,Data> results = new HashMap<Future<Foo>,Data>();
for (Data data : dataList) {
    Callable<Foo> thread = new FooCallable(data);
    Future<Foo> result = this.executorService.submit(thread);
    results.put(result,data);
}

Iterator<Map.Entry<Future<Foo>,Data>> resultsIterator = results.entrySet().iterator();
while(resultsIterator.hasNext()) {
    Map.Entry<Future<Foo>,Data> entry = resultsIterator.next();
    Future<Foo> future = entry.getKey();
    Data data = entry.getValue();
    Foo foo;
    try {
        foo = future.get();
    } catch (InterruptedException e) {
        //data accessible here
    } catch (ExecutionException e) {
        //data accessible here too
    }
}