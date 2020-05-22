public static void startServer() {
    try {
        final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(12345);
        final List<Operator> operators = new ArrayList<>();
        final int nOperators = /* your choice */;
        for (int i = 0; i < nOperators; i++) {
            operators.add(i, new Operator());
        }
        final int parallelism = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(parallelism);
        pool.submit(() -> new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    operators.get(i).newOperation(serverSocketChannel.accept());
                    i++;
                    if (i == nOperators) {
                        i = 0;
                    }
                } catch (IOException ignored) {
                }
            }
        })).fork().invoke().start();
    } catch (IOException ignored) {
    }
}