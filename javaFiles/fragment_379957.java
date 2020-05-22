public abstract class ParentTransaction {
     protected BigDecimal value1
     protected String value2

     public ParentTransaction(BigDecimal value1, String value2) {
         this.value1 = value1;
         this.value2 = value2;
     }
}

public class TransactionB extends ParentTransaction {
   public TransactionB(BigDecimal amountSend, String referenceSend) {
       super(amountSend, referenceSend);
   }
   BigDecimal getAmountSend() {
       return value1;
   }
   String getReferenceSend() {
       return value2;
   }
}

public class Transaction30 extends ParentTransaction {
   public TransactionB(BigDecimal account, String reference) {
       super(account, reference);
   }
   BigDecimal getAccount() {
       return value1;
   }
   String getReference() {
       return value2;
   }
}