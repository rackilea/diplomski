public class Internet {
    AtomicReference<String> address = new AtomicReference<String>();
    public String getAddress(){
        String s = address.get();
        return s == null ? null : s.toString();
    }
    public void setAddress(String address) {
        this.address.set(address);
    }
}