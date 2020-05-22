IntStream.rangeClosed(0, 300_000)
         .parallel()
         .mapToObj(i -> web3.ethGetBlockByNumber(new DefaultBlockParameterNumber(BigInteger.valueOf(i)), true).send())
         .filter(Objects::nonNull)
         .map(EthBlock::getBlock)
         .filter(Objects::nonNull)
         .collect(Collectors.toList());