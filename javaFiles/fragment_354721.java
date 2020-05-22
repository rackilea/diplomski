public class ReconnectionListener implements ConnectionListener
    {   

        @Override
        public void reconnectionSuccessful()
        {
            System.out.println( "Connection to chat server restored - You are again online" );

    //additional foo when connection restored
        }

        @Override
        public void reconnectionFailed( Exception e )
        {
            System.out.println("Impossible to reconnect, Chat Server seems to be still unavailable" );

        }

        @Override
        public void reconnectingIn( int seconds )
        {
            System.out.println( "reconnectingIn fired "+seconds);
        }

        @Override
        public void connectionClosedOnError( Exception e )
        {
            System.out.println("Connection closed, Chat Server become unavailable" );
    //additional  foo when connection lost (message to user ?)
        }

        @Override
        public void connectionClosed()
        {
            // "XMPP connection was closed.");
            System.out.println( "Connection closed, Chat Server become unavailable");
        }

        @Override
        public void connected( XMPPConnection connection )
        {
            System.out.println("connected fired - reconnection management enabled");
        }

        @Override
        public void authenticated( XMPPConnection connection, boolean resumed )
        {
            System.out.println("authenticated fired");      
        }

    }