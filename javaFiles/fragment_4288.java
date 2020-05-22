public class BankOperationComputed {
      private final BankOperation operation;
      private final int delta; 

      BankOperationComputed (BankOperation operation, int delta){
         this.operation = operation;
         this.delta = delta;
      }
      public void startProcessing(){
           System.out.println(operation.getOutput(delta));
      }
}