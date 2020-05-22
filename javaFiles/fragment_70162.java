class ClientThread extends Thread {

    private Socket          sock;
    private InputStream     in;
    private OutputStream    out;

    ClientThread( Socket sock ) {
        this.sock = sock;
        try {
            this.in = sock.getInputStream();
            this.out = sock.getOutputStream();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    //Echos whatever the client sends to it
    public void run() {
        BufferedReader bufIn = new BufferedReader( new InputStreamReader( in ) );
        BufferedWriter bufOut = new BufferedWriter( new OutputStreamWriter( out ) );
        while ( true ) {
            try {
                String msg = bufIn.readLine();
                System.out.println( "Received: " + msg );
                bufOut.write( msg );
                bufOut.newLine(); //HERE!!!!!!
                bufOut.flush();
            } catch ( IOException e ) {
                e.printStackTrace();
            }

        }
    }

}