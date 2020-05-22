List<EthBlock.Block> blocks = Collections.synchronizedList(new ArrayList<>(300_000));

ExecutorService service = Executors.newCachedThreadPool();

for (int i = 0; i <= 300_000; i++) {
    BigInteger number = BigInteger.valueOf(i);

    service.execute(() -> {
        EthBlock eb = web3.ethGetBlockByNumber(new DefaultBlockParameterNumber(number), true).send();

        if (eb == null) {
            return;
        }

        EthBlock.Block block = eb.getBlock();

        if (block != null) {
            blocks.add(block);
        }
    });
}