public enum ApplicationStatus {
    Initiated(1), PendingVerification(2), NotEligible(3), Approved(4), 
    SoftDenial(5), Deferred(6), Saved(7), Cancelled(8), 
    Approved_NoSSN(9),PendingVerification_NoSSN(10), 
    Approved_Archeived(11);

    private final int value;
    // redundant representation of ordinal() as a string for comparison to other strings
    private final String ordinalAsString;

    private ApplicationStatus(int value) {
        this.value = value;
        ordinalAsString = String.valueOf(ordinal());
    }

    public int getStatusMasterId() {
        return value;
    }

    public boolean compare(String stringValue) {
        return this.ordinalAsString.equals(stringValue);
    }
}