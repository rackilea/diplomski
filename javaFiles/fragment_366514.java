Class Connection {//possibly implements runnable
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;

    public Connection(Socket s) {
        this.socket = s;
        this.in = s.getInputStream();
        this.out = s.getOutputStream();
    }

    public void sendData(Object o)
    {
        out.sendObject(o);
    }
}