class ServerApplication {
    Server server;
    ServerFrame gui;

    public static void main(String []) {
        server = new Server(...);
        gui = new ServerFrame(server);
        server.setGui(gui);
    }
}