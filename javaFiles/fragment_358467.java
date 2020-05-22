HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
    HttpContext cc  = server.createContext("/test", new MyHandler());
    cc.setAuthenticator(new BasicAuthenticator("test") {
        @Override
        public boolean checkCredentials(String user, String pwd) {
            return user.equals("test") && pwd.equals("test");
        }
    });
    server.setExecutor(null); // creates a default executor
    server.start();