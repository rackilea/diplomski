Socket socket;
public NumberAdditionUI() {
    try {
        socket = new Socket("192.168.1.3", 4917);
    } catch (UnknownHostException e) {
        // ...
    } catch (IOException e) {
        // ...
    }
}
// OR
public NumberAdditionUI() throws UnknownHostException, IOException {
    socket = new Socket("192.168.1.3", 4917);
}