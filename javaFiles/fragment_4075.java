public interface rfid_data extends Callback{
    public void callback(int dataId, int dataLength, Pointer data);
}

rfid_data cb = new rfid_data() {
    public void callback(int dataId, int dataLength, Pointer data) {
        byte[] buffer = data.getByteArray(0, dataLength);
        // Alternatively, if the incoming data is a NUL-terminated C string
        String s = data.getString(0);
        // ...
    }
};