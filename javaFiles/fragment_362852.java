public TFileReader(Client cli) throws IOException {
    this.cli = cli;
    socket = new Socket(cli.ServerIp(), cli.FilePort());
    out = new ObjectOutputStream(socket.getOutputStream());
    out.flush();
    in = new ObjectInputStream(socket.getInputStream());
}

public void writeObject(Object o) throw IOException {
    out.writeObject(o);
    out.reset();
    out.flush();
}

public <T> T readObject() throw IOException {
    return (T) in.readObject();
}

public void close() throws IOException {
    in.close();
    out.close();
    socket.close();
}