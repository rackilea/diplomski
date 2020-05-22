foo().thenCompose(x -> x == null
        ? completedFuture(null)
        : completedFuture(x)
            .then.....(...)
            .then.....(...)
).join();