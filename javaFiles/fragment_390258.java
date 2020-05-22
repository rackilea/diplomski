public Matrix multiply(Matrix multiplier) throws InterruptedException {
     Matrix result = new Matrix(dimension);
     List<Future<?>> futures = new ArrayList<Future<?>>();
     for(int currRow = 0; currRow < multiplier.dimension; currRow++) {
         Runnable worker = new MatrixThread2(this, multiplier, currRow, result);
         futures.add(workerPool.submit(worker)); 
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


private static class MatrixThread2 implements Runnable
{
   private Matrix self, mul, result;
   private int row, col;      

   private MatrixThread2(Matrix a, Matrix b, int row, Matrix result)
   {         
      this.self = a;
      this.mul = b;
      this.row = row;
      this.result = result;
   }

   @Override
   public void run()
   {
      for(int col = 0; col < mul.dimension; col++) {
         int cellResult = 0;
         for (int i = 0; i < self.getMatrixDimension(); i++)
            cellResult += self.template[row][i] * mul.template[i][col];
         result.template[row][col] = cellResult;
      }
   }
}