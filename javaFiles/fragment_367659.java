public static void doStuffOnList(List<MyObject> myObjs) {
    myObjs.stream()
            .flatMap(o -> completedFuture(o)
                    .thenAccept(ABC::doStuff)
                    .handle((x, ex) -> ex != null ? Stream.of(ex) : null)
                    .join()
            ).reduce((ex1, ex2) -> {
                ex1.addSuppressed(ex2);
                return ex1;
            }).ifPresent(ex -> {
                throw new RuntimeException(ex);
            });
}