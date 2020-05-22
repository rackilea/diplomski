public static void main(String[] args) throws Exception {

    HttpServer server = null;

    try {
        server = GrizzlyServerFactory.createHttpServer("http://localhost:5555");
        System.out.println("Press any key to stop the service...");
        System.in.read();
    } finally {
        try {
            if (server != null) {
                server.stop();
            }
        } finally {
            ;
        }
    }
}