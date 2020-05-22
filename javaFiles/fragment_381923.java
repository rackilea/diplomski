List<CompletableFuture<User>> usersResult = IntStream.range(1, 10)
        .boxed()
        .map(num -> prefix.concat("" + num))
        .map(name -> CompletableFuture.supplyAsync(() -> callApi(name))
            .exceptionally(e -> {
                e.printStackTrace();
                return null;
            }))
        .collect(Collectors.toList());

List<User> users = usersResult
        .stream()
        .map(CompletableFuture::join)
        .filter(Objects::nonNull)
        .collect(Collectors.toList());