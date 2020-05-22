public enum EmailSendingOption {

    SAMPLEMAIL(1), BULKUSERS(2), ALLUSERS(101);

    private final int emailSendingOptionType;

    private EmailSendingOption(int emailSendingOptionType) {
        this.emailSendingOptionType = emailSendingOptionType;
    }

    public int getEmailSendingOption() {
        return emailSendingOptionType;
    }

}