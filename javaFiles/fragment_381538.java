public class Server extends Thread {

    final private ServerSocket m_serverSocket;
    final public static int MAX_CLIENTS = 3000;
    final private SubServer[] m_clientConnections = new SubServer[ MAX_CLIENTS ];

    public Server( int port ) throws IOException {
         this.m_serverSocket = new ServerSocket( port );
         start();
    }

    @Override
    public void run() {
        while ( !this.interrupted() ) {
             //wait for clients
             Socket connection = this.m_serverSocket.accept();
             assignConnectionToSubServer( connection );
        }
    }

    public void assignConnectionToSubServer( Socket connection ) {
         for ( int i = 0 ; i < MAX_CLIENTS ; i++ ) {

             //find an unassigned subserver (waiter)
             if ( this.m_clientConnections[ i ] == null ) {
                  this.m_clientConnections[ i ] = new SubServer( connection , i );
                  break;
             }
         }
    }

    protected class SubServer extends Thread {

        final private int m_id;
        final private Socket m_connection;

        //you can store additional client properties here if you want, for example:
        private int m_gameRating = 1500;

        public SubServer( Socket connection , int id ) {
            this.m_id = id;
            this.m_connection = connection;
            start();
        }

        @Override
        public void run() {
             while( !this.interrupted() ) {
                 //process a client request
                 //this is for you to implement
             }
        }

        //as an example, if you read String messages from your client,
        //just call this method from the run() method to process the client request
        public void process( String message ) {

        }

        /**
         * terminates the connection with this client (i.e. stops serving him)
         */
        public void close() {
            try {
                 this.m_connection.close();
            } catch ( IOException e ) {
                 //ignore
            }
        }
    }
}