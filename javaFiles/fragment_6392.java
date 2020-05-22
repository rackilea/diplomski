serverConnectionHandler = new ServerConnections(new ITypedCallback<Socket>() {
        @Override
        public void execute(Socket socket) {
            // do something with your socket here
        }
});