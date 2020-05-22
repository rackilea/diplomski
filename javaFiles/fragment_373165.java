class Server {
    public static void main(String[] args) {
        // Set up an OutputStream sink, e.g. writing to a socket (not shown)
        ...
        ObjectOutputStream out = new ObjectOutputStream(sink);
        out.writeObject(new Data("data goes here"));
        out.flush();
        out.close();
    }
}

class Client {
    public static void main(String[] args) {
        // Set up an InputStream source (not shown)
        ...
        ObjectInputStream in = new ObjectInputStream(source);
        Data d = (Data)in.readObject();
        System.out.println(d.getData());
    }
}

class Data implements java.io.Serializable {
    private String data;
    public Data(String d) {
        data = d;
    }
    public String getData() {
        return data;
    }
}