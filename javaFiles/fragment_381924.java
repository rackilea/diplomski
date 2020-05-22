final CompletableFuture<List<User>> result =
        CompletableFuture.allOf(usersResult.stream().toArray(CompletableFuture[]::new))
                .thenApply(__ -> usersResult
                        .stream()
                        .map(CompletableFuture::join)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()));