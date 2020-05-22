class Manager {
    private Server server;

    public Manager(Server server) {
        this.server = server;
    }

    ResultSet find(String searchText) {
        server.find(searchText);
    }

    ResultSet fetch(String fetchText) {
        server.fetch(fetchText);
    }

    void save(String saveText) {
        server.save(saveText);
    }
}