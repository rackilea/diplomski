private static void executeFutures(List<Future> futures) throws CustomException {
    for (Future f : futures) {
        try {
            f.get();
        } catch (ExecutionException | InterruptedException e) {
            if (e.getCause() instanceof CustomException) {
                throw (CustomException) e.getCause();
            }
        }
    }
}