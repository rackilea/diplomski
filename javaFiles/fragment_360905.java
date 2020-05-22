class Server {
    ServerFrame gui;

    public void setGui(ServerFrame gui) {
        this.gui = gui;
    }

    ...
}

class ServerFrame extends JFrame {
    Server server;

    public ServerFrame(Server server) {
        this.server = server;
    }

    ...
}