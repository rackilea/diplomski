// Using Date
class MyObj {
    private final Date createdDate = new java.util.Date();

    public int getAgeInSeconds() {
        java.util.Date now = new java.util.Date();
        return (int)((now.getTime() - this.createdDate.getTime()) / 1000);
    }
}