ch.pipeline().addLast(
    new HttpServerCodec(),
    new HttpObjectAggregator(65536), // Handle POST/PUT requests up 64KB
    new HttpMessageHandler(),
    new CalculatorOperationHandler()
);