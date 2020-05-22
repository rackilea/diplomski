public static void main( String[] args ) throws Exception {

    java.io.Closeable server = null;

    try {
        // Creates a server and listens on the address below.
        // Scans classpath for JAX-RS resources
        server = SimpleServerFactory.create("http://localhost:5555");
        System.out.println("Press any key to stop the service...");
        System.in.read();
    } finally {
        try {
            if (server != null) {
                server.close();
            }
        } finally {
            ;
        }
    }
}