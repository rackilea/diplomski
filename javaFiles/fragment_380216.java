public class Receiver{
private ArrayList<SocketStream> socketStreams;
    private OnNewSocketListener listener;
    private ServerSocket server;
    private Thread thread;
    private int port;

    public static interface OnNewSocketListener{
        void onNewSocket (Stream stream);
    }

    public Receiver (int port, OnNewSocketListener listener){
        this.listener = listener;
            this.port = port;
    }

    public synchronized start (){
        if (thread != null) return;

        server = new ServerSocket (port);
        thread = new Thread (new Runnable (){
                @Override
                public void run (){
                    try{
                        running = true;
                        while (running){
                        socketStreams.add (stream);
                                                    //See Stream.java below
                            listener.onNewSocket (new Stream (server.accept ()));
                        }
                    }catch (SocketException e){
                        //stop() has been called
                    }catch (IOException e){
                        //Error handling
                    }
                }
            }).start ();
        }
    }

    public synchronized void stop (){
        if (thread == null) return;

        running = false;
        try{
            if (server != null){
                server.close ();
            }
        }catch (IOException e){}

    for (SocketStream stream: socketStreams){
        stream.close ();
    }
    socketStreams.clear ();

        thread = null;
    }
}