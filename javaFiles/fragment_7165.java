public static enum STATUS{
    STARTED("STRTD"), COMPLETED("COMP");
    public final String status;
    private STATUS(String status) {
        this.status = status;
    }
}