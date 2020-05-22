public class Internet {
    private final Object lock = new Object();
    private String s;
    public String getAddress() {
       synchronized(lock) {
           return s;
       }
    }
    public void setAddress(String s) {
        synchronized(lock) {
            this.s = s;
        }
    }
}