public class TransactionResult {

    private final boolean failed;
    private final String reason;

    /** Construct a result that represents a successful transaction. */
    public TransactionResult () { 
        failed = false; 
        reason = null;
    }

    /** Construct a result that represents a failed transaction with a reason. */
    public TransactionResult (String failedReason) {
        failed = true;
        reason = failedReason;
    }

    public boolean isFailed () {
        return failed;
    }

    public String getReason () {
        return reason;
    }

}