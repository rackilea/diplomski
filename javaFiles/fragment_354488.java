future
        .exceptionally(throwable -> {
            System.out.println("EXCEPTION 2: " +throwable.getLocalizedMessage());
            return null;
        })
        .thenAcceptAsync(o -> {
            throw new RuntimeException("Some random exception happened.");
        })
        .exceptionally(throwable -> {
            System.out.println("EXCEPTION 1: " + throwable.getLocalizedMessage());
            return null;
        });