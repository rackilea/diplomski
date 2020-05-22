makeServiceCall(input)
    .thenApplyAsync(Output::getName)
    .thenAcceptAsync(this::processName)
    .exceptionally(e -> {
        //log the error
        System.out.printf("Oops - %s%n", e);
        //return some useful default value
        return ProcessingResult.SUCCESSFUL;
    });