Thread thread = new Thread(new Runnable() {

    @Override
    public void run() {
        try  {
            Socket socket = new Socket("192.168.1.94",60);
            DataOutputStream DOS = new 
            DataOutputStream(socket.getOutputStream());
            DOS.writeUTF("HELLO_WORLD");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});

thread.start();