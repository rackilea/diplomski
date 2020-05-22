@Override
    public Map<String, CompletableFuture<String>> call() throws Exception {

        for (int j = 0; j < listString.size(); ++j) {
            CompletableFuture<String> future = someMethod();        
            futureMap.put(listString.get(j), future);
        }
        // This will wait for all the futures inside the map to terminate
        try {
            CompletableFuture.allOf(futureMap.values().toArray(new CompletableFuture[0])).join();
        } catch (CompletionException e) {
            // ignored - the status will be checked later on
        }

        return futureMap;
    }