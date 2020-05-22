public static enum STATUS{
    STARTED("STRTD"), COMPLETED("COMP");
    private final String status;
    private STATUS(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }
}