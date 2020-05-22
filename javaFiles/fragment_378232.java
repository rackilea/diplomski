ExecutorService es = Executors.newCachedThreadPool();
List<GitUser> result =
    es.invokeAll(
        Stream.of(service1, service2, service3)
              .<Callable<GitUser>>map(s -> s::getGitUser)
              .collect(Collectors.toList())
    ) .stream()
      .map(future -> {
            try { return future.get(); }
            catch (InterruptedException|ExecutionException ex) {
                throw new IllegalStateException(ex);
            }
        })
      .collect(Collectors.toList());