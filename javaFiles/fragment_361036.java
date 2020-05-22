Socket s = new Socket();

System.out.println("isConnected: " + s.isConnected() +
                  " isBound: "     + s.isBound() +
                  " isClosed: "    + s.isClosed());

s.connect(new InetSocketAddress("google.com", 80));

System.out.println("isConnected: " + s.isConnected() +
                   " isBound: "    + s.isBound() +
                   " isClosed: "   + s.isClosed());

s.close();

System.out.println("isConnected: " + s.isConnected() +
                   " isBound: "    + s.isBound() +
                   " isClosed: "   + s.isClosed());