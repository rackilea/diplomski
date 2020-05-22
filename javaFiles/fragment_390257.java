public Matrix multiply(Matrix multiplier) throws InterruptedException {
    Matrix result = new Matrix(dimension);
    List<Future<?>> futures = new ArrayList<Future<?>>();
    for(int currRow = 0; currRow < multiplier.dimension; currRow++) {
        for(int currCol = 0; currCol < multiplier.dimension; currCol++) {            
            Runnable worker = new MatrixThread(this, multiplier, currRow, currCol, result);
            futures.add(workerPool.submit(worker));
        }
    }
    for (Future<?> f : futures) {
        try {
            f.get();
        } catch (ExecutionException e){
            throw new RuntimeException(e); // shouldn't happen, but might do
        }
    }
    return result;
}